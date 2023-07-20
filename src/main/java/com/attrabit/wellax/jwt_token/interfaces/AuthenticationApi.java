package com.attrabit.wellax.jwt_token.interfaces;

import com.attrabit.wellax.jwt_token.dto.AuthenticationRequest;
import com.attrabit.wellax.jwt_token.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth")
//@CrossOrigin("http://localhost:4200")
public interface AuthenticationApi {
    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody RegisterRequest dto);
    @PostMapping("/authenticate")
    ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest dto);
}
