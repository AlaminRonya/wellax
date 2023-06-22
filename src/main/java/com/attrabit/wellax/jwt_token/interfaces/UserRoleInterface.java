package com.attrabit.wellax.jwt_token.interfaces;

import com.attrabit.wellax.dto.RequestEmailRoleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/subAdmin")
@PreAuthorize("hasAnyRole('SUB_ADMIN','ADMIN')")
public interface UserRoleInterface {
    @PutMapping
    @PreAuthorize("hasAnyAuthority('user:update')")
    ResponseEntity<?> updatedRole(@RequestBody RequestEmailRoleDTO dto) throws Exception;
}
