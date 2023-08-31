package com.ivan.mediappbackend.service;

import com.ivan.mediappbackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPatientService {
    Patient save(Patient patient);
    Patient update(Patient patient, Integer Id);
    List<Patient> findAll();
    Patient findById(Integer Id);
    void delete(Integer Id);
}
