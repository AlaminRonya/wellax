package com.attrabit.wellax.jwt_token.api;

import com.attrabit.wellax.dto.RequestEmailRoleDTO;
import com.attrabit.wellax.jwt_token.interfaces.UserRoleInterface;
import com.attrabit.wellax.service.AdminAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubAdminController implements UserRoleInterface {
    private final AdminAppUserService adminAppUserService;
    @Override
    public ResponseEntity<?> updatedRole(RequestEmailRoleDTO dto) throws Exception {
        adminAppUserService.updateUserRole(dto);
        return new ResponseEntity<>("Updated user role", HttpStatus.OK);
    }
}
