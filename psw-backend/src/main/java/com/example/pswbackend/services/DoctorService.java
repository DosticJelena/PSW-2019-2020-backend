package com.example.pswbackend.services;

import com.example.pswbackend.domain.Doctor;
import com.example.pswbackend.dto.*;

import java.util.List;

public interface DoctorService {

    boolean scheduleAppointment(AppointmentDoctorDTO dto);

    Doctor findById(long id);
    List<Doctor> findByClinicId(long id);

    List<Doctor> findAll();

    Doctor getLoggedInDoctor();
    List<ResultDoctorDTO> filterDoctors(FilterDoctorsDTO dto);

}
