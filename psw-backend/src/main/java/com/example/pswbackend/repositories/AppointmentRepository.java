package com.example.pswbackend.repositories;

import com.example.pswbackend.domain.Appointment;
import com.example.pswbackend.enums.AppointmentEnum;
import com.example.pswbackend.enums.AppointmentStatus;
import com.example.pswbackend.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Appointment findOneById(Long id);
    List<Appointment> findAll();
    List<Appointment> findByClinicId(Long id);

    List<Appointment> findByDoctorsIdAndStatusNot(Long id, AppointmentStatus appointmentStatus);
    List<Appointment> findByOrdinationIdAndStatusNotOrderByStartDateTime(Long id, AppointmentStatus appointmentStatus);
    List<Appointment> findByNurseIdAndStatusNot(Long id, AppointmentStatus appointmentStatus);
    Appointment getByIdAndStatusNot(Long id, AppointmentStatus appointmentStatus);
    List<Appointment> findByStatus(AppointmentStatus appointmentStatus);
    Appointment findByPatientIdAndDoctorsIdAndDoctorsUserStatusAndStartDateTimeLessThanEqualAndEndDateTimeGreaterThanAndStatusIn(
            Long patientId, Long doctorsId, UserStatus userStatus, LocalDateTime start, LocalDateTime end, List<AppointmentStatus> appointmentEnums);

}


