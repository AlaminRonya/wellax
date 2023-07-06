package com.attrabit.wellax.controller;

import com.attrabit.wellax.dto.request.RequestDoctorDTO;
import com.attrabit.wellax.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminAddController {
    private final DoctorService doctorService;
    @PostMapping("/adminAddDoctor")
    public ResponseEntity<?> addDoctor(@RequestBody RequestDoctorDTO dto) throws Exception {
        doctorService.add(dto);
        System.out.println(dto);
        return new ResponseEntity<>("Inserted", HttpStatus.CREATED);
    }
}
