package com.attrabit.wellax.jwt_token.api;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
@PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
public class ManagementController {
    @GetMapping
    @PreAuthorize("hasAnyAuthority('management:read','admin:read')")
    public String get() {
        return "GET:: management controller";
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('management:create','admin:create')")
    public String post() {
        return "POST:: management controller";
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('management:update','admin:update')")
    public String put() {
        return "PUT:: management controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('management:delete','admin:delete')")
    public String delete() {
        return "DELETE:: management controller";
    }
}

