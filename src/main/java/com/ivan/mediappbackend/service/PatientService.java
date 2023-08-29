package com.ivan.mediappbackend.service;

import com.ivan.mediappbackend.model.Patient;
import com.ivan.mediappbackend.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    // Autowired annotation is used for automatic dependency injection.
    @Autowired
    private PatientRepo repo;

    public String sayHelloLogic(Patient patient) {
        return patient != null ? repo.sayHello(patient) : "The patient doesn't exist";
    }

}
