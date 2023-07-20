package com.attrabit.wellax.jwt_token.api;

import com.attrabit.wellax.jwt_token.dto.AuthenticationRequest;
import com.attrabit.wellax.jwt_token.dto.RegisterRequest;
import com.attrabit.wellax.jwt_token.interfaces.AuthenticationApi;
import com.attrabit.wellax.jwt_token.model.Role;
import com.attrabit.wellax.jwt_token.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationApi {
    private final AuthenticationService authenticationService;

    @Override
    public ResponseEntity<?> register(RegisterRequest dto) {
        if (dto.getRole() == null){
            dto.setRole(Role.USER);
        }
        return new ResponseEntity<>(authenticationService.register(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> authenticate(AuthenticationRequest dto) {
        return new ResponseEntity<>(authenticationService.authenticate(dto), HttpStatus.CREATED);
    }
}