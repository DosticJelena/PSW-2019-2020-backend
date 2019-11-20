package com.example.pswbackend.controllers;

import com.example.pswbackend.domain.Patient;
import com.example.pswbackend.enums.Status;
import com.example.pswbackend.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

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

    @GetMapping("/patients")
    public List<Patient> getPatients() {

        return patientRepository.findAll();
    }

    //TODO update/delete patient
}
