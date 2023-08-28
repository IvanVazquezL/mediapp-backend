package com.ivan.mediappbackend.repo;

import com.ivan.mediappbackend.model.Patient;

public class PatientRepo {
    public String sayHello(Patient patient) {
        return "Hi, " + patient.getFirstName();
    }
}
