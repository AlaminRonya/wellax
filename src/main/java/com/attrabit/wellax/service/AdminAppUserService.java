package com.attrabit.wellax.service;

import com.attrabit.wellax.dto.RequestEmailRoleDTO;
import com.attrabit.wellax.jwt_token.model.AppUserEntity;

import java.util.UUID;

public interface AdminAppUserService {
    void updateUserRole(RequestEmailRoleDTO dto) throws Exception;
    void deleteUserByEmail(String email) throws Exception;
    AppUserEntity searchUser(String email) throws Exception;
    void groupOfUser(String role) throws Exception;

}
