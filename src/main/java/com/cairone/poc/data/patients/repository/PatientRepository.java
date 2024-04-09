package com.cairone.poc.data.patients.repository;

import com.cairone.poc.data.patients.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
