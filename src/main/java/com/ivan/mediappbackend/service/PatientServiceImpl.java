
package com.ivan.mediappbackend.service;

import com.ivan.mediappbackend.model.Patient;
import com.ivan.mediappbackend.repo.IPatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//  @RequiredArgsConstructor is used to have constructors with final properties
@RequiredArgsConstructor
public class PatientServiceImpl implements  IPatientService{
    private final IPatientRepo repo;

    @Override
    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public Patient update(Patient patient, Integer Id) {
        patient.setIdPatient(Id);
        return repo.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return repo.findAll();
    }

    @Override
    public Patient findById(Integer Id) {
        return repo.findById(Id).orElse(new Patient());
    }

    @Override
    public void delete(Integer Id) {
        repo.deleteById(Id);
    }
}

