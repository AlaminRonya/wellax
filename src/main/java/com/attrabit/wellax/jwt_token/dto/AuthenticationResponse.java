package com.attrabit.wellax.jwt_token.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    //    @JsonProperty("access_token")
    private String accessToken;
    private String role;
    private String username;
//    @JsonProperty("refresh_token")
//    private String refreshToken;
}