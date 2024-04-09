package com.cairone.poc.core;

import com.cairone.poc.data.doctors.model.DoctorEntity;
import com.cairone.poc.data.doctors.repository.DoctorRepository;
import com.cairone.poc.data.patients.model.PatientEntity;
import com.cairone.poc.data.patients.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FooService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public void run() {
        doctorRepository.findAll().forEach(doctor -> log.info(doctor.toString()));
        patientRepository.findAll().forEach(patient -> log.info(patient.toString()));
    }

    public void create() {

        doctorRepository.saveAndFlush(new DoctorEntity(100L, "Dr. House"));
        doctorRepository.saveAndFlush(new DoctorEntity(110L, "Dr. Strange"));
        doctorRepository.saveAndFlush(new DoctorEntity(120L, "Dr. Who"));

        patientRepository.saveAndFlush(new PatientEntity(10L, "John Doe 1", 1L));
        patientRepository.saveAndFlush(new PatientEntity(11L, "Jane Doe", 2L));

        log.info("Doctors and patients created");
    }
}
