package com.cairone.poc.data.patients.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "patients")
public class PatientEntity {

    @Id
    @Column(name = "patient_id")
    private Long id;

    @Column(name = "names", length = 200, nullable = false)
    private String names;

    @Column(name = "doctor_id")
    private Long doctorId;

    public PatientEntity() {
    }

    public PatientEntity(Long id, String names, Long doctorId) {
        this.id = id;
        this.names = names;
        this.doctorId = doctorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id=" + id +
                ", names='" + names + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
