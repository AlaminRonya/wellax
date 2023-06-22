package com.attrabit.wellax.service;

import com.attrabit.wellax.dto.RequestEmailRoleDTO;
import com.attrabit.wellax.jwt_token.model.AppUserEntity;
import com.attrabit.wellax.jwt_token.model.Role;
import com.attrabit.wellax.jwt_token.repo.AppUserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AdminAppUserService{
    private final AppUserEntityRepository appUserEntityRepository;
    @Override
    public void updateUserRole(RequestEmailRoleDTO dto) throws Exception {

        final AppUserEntity appUser = getUser(dto.email());
        changeRolePermission(appUser, dto.roleName());
        appUserEntityRepository.save(appUser);
    }

    @Override
    public void deleteUserByEmail(String email) throws Exception {
        final AppUserEntity appUser = getUser(email);
        appUserEntityRepository.deleteById(appUser.getId());
    }

    @Override
    public void searchUser(String email) throws Exception {
        final AppUserEntity appUser = getUser(email);

    }

    @Override
    public void groupOfUser(String role) throws Exception {

    }
    private AppUserEntity getUser(String email) throws Exception {
        return appUserEntityRepository.findByEmail(email).orElseThrow(()->new Exception("Invalid email"));
    }
    private void changeRolePermission(AppUserEntity appUser, String roleName){
        if (roleName.equals(Role.ADMIN.name())){
            appUser.setRole(Role.ADMIN);
        }else if (roleName.equals(Role.SUB_ADMIN.name())){
            appUser.setRole(Role.SUB_ADMIN);
        }else if (roleName.equals(Role.MANAGER.name())){
            appUser.setRole(Role.MANAGER);
        }else if (roleName.equals(Role.DOCTOR.name())){
            appUser.setRole(Role.DOCTOR);
        }else if (roleName.equals(Role.PATIENT.name())){
            appUser.setRole(Role.PATIENT);
        }
    }
}
