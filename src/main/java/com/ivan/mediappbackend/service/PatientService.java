package com.ivan.mediappbackend.service;

import com.ivan.mediappbackend.model.Patient;
import com.ivan.mediappbackend.repo.PatientRepo;

public class PatientService {
    private PatientRepo repo = new PatientRepo();

    public String sayHelloLogic(Patient patient) {
        return patient != null ? repo.sayHello(patient) : "The patient doesn't exist";
    }

}
