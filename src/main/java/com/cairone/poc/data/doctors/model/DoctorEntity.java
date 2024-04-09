package com.cairone.poc.data.doctors.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "doctors")
public class DoctorEntity {

    @Id
    @Column(name = "doctor_id")
    private Long id;

    @Column(name = "names", length = 200, nullable = false)
    private String names;

    public DoctorEntity() {
    }

    public DoctorEntity(Long id, String names) {
        this.id = id;
        this.names = names;
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

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "id=" + id +
                ", names='" + names + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEntity that = (DoctorEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
