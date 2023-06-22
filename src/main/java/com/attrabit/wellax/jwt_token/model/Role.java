package com.attrabit.wellax.jwt_token.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.attrabit.wellax.jwt_token.model.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_CREATE,
                    ADMIN_DELETE,
                    SUB_ADMIN_READ,
                    SUB_ADMIN_UPDATE,
                    SUB_ADMIN_CREATE,
                    SUB_ADMIN_DELETE,
                    MANAGER_READ,
                    MANAGER_CREATE,
                    MANAGER_DELETE,
                    MANAGER_UPDATE,
                    DOCTOR_READ,
                    DOCTOR_CREATE,
                    DOCTOR_DELETE,
                    DOCTOR_UPDATE,
                    PATIENT_READ,
                    PATIENT_CREATE,
                    PATIENT_DELETE,
                    PATIENT_UPDATE,
                    USER_READ,
                    USER_CREATE,
                    USER_DELETE,
                    USER_UPDATE
            )
    ),
    SUB_ADMIN(
            Set.of(
                    SUB_ADMIN_READ,
                    SUB_ADMIN_UPDATE,
                    SUB_ADMIN_CREATE,
                    SUB_ADMIN_DELETE,
                    DOCTOR_READ,
                    DOCTOR_CREATE,
                    DOCTOR_DELETE,
                    DOCTOR_UPDATE,
                    PATIENT_READ,
                    PATIENT_CREATE,
                    PATIENT_DELETE,
                    PATIENT_UPDATE,
                    USER_READ,
                    USER_CREATE,
                    USER_DELETE,
                    USER_UPDATE
            )
    ),
    MANAGER(
            Set.of(
                    MANAGER_READ,
                    MANAGER_CREATE,
                    MANAGER_DELETE,
                    MANAGER_UPDATE
            )
    ),
    DOCTOR(
            Set.of(
                    DOCTOR_READ,
                    DOCTOR_CREATE,
                    DOCTOR_DELETE,
                    DOCTOR_UPDATE
            )
    ),
    PATIENT(
            Set.of(
                    PATIENT_READ,
                    PATIENT_CREATE,
                    PATIENT_DELETE,
                    PATIENT_UPDATE
            )
    )
    ;
    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}

