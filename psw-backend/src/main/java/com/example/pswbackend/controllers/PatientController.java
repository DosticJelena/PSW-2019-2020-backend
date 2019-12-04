package com.example.pswbackend.controllers;

import com.example.pswbackend.domain.Account;
import com.example.pswbackend.domain.Patient;
import com.example.pswbackend.dto.PatientDTO;
import com.example.pswbackend.enums.Status;
import com.example.pswbackend.repositories.PatientRepository;
import com.example.pswbackend.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @PostMapping("/patient/register")
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient){

        //TODO [security]/password hashing
        patient.setPatientStatus(Status.AWAITING_APPROVAL);
        Patient createPatient = this.patientRepository.save(patient);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/patient")
                .buildAndExpand(createPatient.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable long id) {

        return patientRepository.findById(id).get();
    }

    @GetMapping(value="/patients", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> getPatients() {

        return patientRepository.findAll();
    }

    //TODO update/delete patient
    
    @PutMapping(value="/patients/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Patient updatePatient(@PathVariable long id, PatientDTO dto){

        Patient patient= patientRepository.findById(id).get();

        if(patient==null){
            return null;
        }

        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setAddress(dto.getAddress());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setCity(dto.getCity());
        patient.setCountry(dto.getCountry());
        patient.setPassword(dto.getPassword());

        return patient;
    }

}
