package com.attrabit.wellax.dto.request;

import com.attrabit.wellax.jwt_token.model.Role;

public record RequestDoctorDTO(
        String firstname,
        String lastname,
        String email,
        String password,
        String role,
        String specialization,
        String dob,
        String licenceNumber,
        String contactNumber
) {
}
