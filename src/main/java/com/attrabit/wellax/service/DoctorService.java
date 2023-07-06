package com.attrabit.wellax.service;

import com.attrabit.wellax.dto.request.RequestDoctorDTO;

public interface DoctorService {
    void add(RequestDoctorDTO dto) throws Exception;
}
