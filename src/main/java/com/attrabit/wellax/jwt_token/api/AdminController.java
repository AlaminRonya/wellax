package com.attrabit.wellax.jwt_token.api;


import com.attrabit.wellax.service.AdminAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
//@SecurityRequirement(name = "bearerAuth")
public class AdminController {
    private final AdminAppUserService adminAppUserService;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('','admin:read')")
    public String get() throws Exception {
//        adminAppUserService.updateUserRole("manager@mail.com","ADMIN");
        return "GET:: admin controller";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public String post() {
        return "POST:: admin controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public String put() {
        return "PUT:: admin controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    public String delete() {
        return "DELETE:: admin controller";
    }

}
