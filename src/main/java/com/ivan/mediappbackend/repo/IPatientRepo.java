package com.ivan.mediappbackend.repo;

import com.ivan.mediappbackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository makes all the CRUD for us
public interface IPatientRepo extends JpaRepository<Patient, Integer> {
}
