package com.attrabit.wellax.jwt_token.service;

import com.attrabit.wellax.jwt_token.dto.AuthenticationRequest;
import com.attrabit.wellax.jwt_token.dto.AuthenticationResponse;
import com.attrabit.wellax.jwt_token.dto.RegisterRequest;
import com.attrabit.wellax.jwt_token.model.AppUserEntity;
import com.attrabit.wellax.jwt_token.model.TokenEntity;
import com.attrabit.wellax.jwt_token.model.TokenType;
import com.attrabit.wellax.jwt_token.repo.AppUserEntityRepository;
import com.attrabit.wellax.jwt_token.repo.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AppUserEntityRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;
    public AuthenticationResponse register(RegisterRequest dto) {
        var user = AppUserEntity.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .build();
        var save = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(save, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    private void saveUserToken(AppUserEntity user, String jwtToken) {
        var token = TokenEntity.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }

    public AuthenticationResponse  authenticate(AuthenticationRequest dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );
        var user = repository.findByEmail(dto.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    private void revokeAllUserTokens(AppUserEntity user){
        var validTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validTokens.isEmpty()){
            return;
        }
        validTokens.forEach(t->{
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validTokens);
    }
}
