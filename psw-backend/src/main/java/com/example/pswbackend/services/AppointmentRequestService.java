package com.example.pswbackend.services;

import com.example.pswbackend.domain.AppointmentRequest;
import com.example.pswbackend.domain.ClinicAdmin;
import com.example.pswbackend.dto.AppointmentDoctorDTO;

public interface AppointmentRequestService {

    boolean saveRequest(AppointmentDoctorDTO dto, ClinicAdmin ca);

}