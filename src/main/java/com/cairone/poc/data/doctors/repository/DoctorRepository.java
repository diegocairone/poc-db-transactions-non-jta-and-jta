package com.cairone.poc.data.doctors.repository;

import com.cairone.poc.data.doctors.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

}
