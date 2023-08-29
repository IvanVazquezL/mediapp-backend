package com.ivan.mediappbackend.service;

import com.ivan.mediappbackend.model.Patient;
import com.ivan.mediappbackend.repo.IPatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//  @RequiredArgsConstructor is used to have constructors with final properties
@RequiredArgsConstructor
public class PatientServiceImpl implements  IPatientService{
    private final IPatientRepo repo;

    @Override
    public String sayHelloLogic(Patient patient) {
        return patient != null ? repo.sayHello(patient) : "The patient doesn't exist";
    }

}
