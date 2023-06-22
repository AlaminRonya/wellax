package com.attrabit.wellax.jwt_token.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_CREATE("admin:create"),
    ADMIN_SEARCH("admin:search"),
    SUB_ADMIN_READ("sub_admin:read"),
    SUB_ADMIN_UPDATE("sub_admin:update"),
    SUB_ADMIN_DELETE("sub_admin:delete"),
    SUB_ADMIN_CREATE("sub_admin:create"),
    SUB_ADMIN_SEARCH("sub_admin:search"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_DELETE("management:delete"),
    MANAGER_CREATE("management:create"),
    MANAGER_SEARCH("management:search"),
    DOCTOR_READ("doctor:read"),
    DOCTOR_UPDATE("doctor:update"),
    DOCTOR_DELETE("doctor:delete"),
    DOCTOR_CREATE("doctor:create"),
    DOCTOR_SEARCH("doctor:search"),
    PATIENT_READ("patient:read"),
    PATIENT_UPDATE("patient:update"),
    PATIENT_DELETE("patient:delete"),
    PATIENT_CREATE("patient:create"),
    PATIENT_SEARCH("patient:search"),
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete"),
    USER_CREATE("user:create"),
    USER_SEARCH("user:search")
    ;
    @Getter
    private final String permission;
}
