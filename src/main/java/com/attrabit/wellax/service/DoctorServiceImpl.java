package com.attrabit.wellax.service;

import com.attrabit.wellax.dto.request.RequestDoctorDTO;
import com.attrabit.wellax.entity.Doctor;
import com.attrabit.wellax.jwt_token.dto.AuthenticationResponse;
import com.attrabit.wellax.jwt_token.dto.RegisterRequest;
import com.attrabit.wellax.jwt_token.model.AppUserEntity;
import com.attrabit.wellax.jwt_token.model.Role;
import com.attrabit.wellax.jwt_token.repo.AppUserEntityRepository;
import com.attrabit.wellax.jwt_token.service.AuthenticationService;
import com.attrabit.wellax.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.attrabit.wellax.jwt_token.model.Role.DOCTOR;
import static com.attrabit.wellax.jwt_token.model.Role.SUB_ADMIN;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{
    private final AppUserEntityRepository appUserEntityRepository;
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;
    private final DoctorRepository doctorRepository;
    @Transactional
    @Override
    public void add(RequestDoctorDTO dto) throws Exception {
        final boolean present = appUserEntityRepository.findByEmail(dto.email()).isPresent();
        if (present){
            return;
        }

//        var subAdmin = RegisterRequest.builder()
//                .firstname(dto.firstname())
//                .lastname(dto.lastname())
//                .email(dto.email())
//                .password(dto.password())
//                .role(DOCTOR)
//                .build();

        var user = AppUserEntity.builder()
                .firstname(dto.firstname())
                .lastname(dto.lastname())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .role(DOCTOR)
                .build();
        final AppUserEntity appUser = appUserEntityRepository.save(user);

        final Doctor doctor = Doctor.builder()
                .specialization(dto.specialization())
                .licenceNumber(dto.licenceNumber())
                .appUser(appUser).build();

        final Doctor save = doctorRepository.save(doctor);


    }
}
