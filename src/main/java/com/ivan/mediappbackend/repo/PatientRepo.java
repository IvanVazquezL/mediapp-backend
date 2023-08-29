package com.ivan.mediappbackend.repo;

import com.ivan.mediappbackend.model.Patient;
import org.springframework.stereotype.Repository;

// Stereotype to recognize the class
@Repository
public class PatientRepo {
    public String sayHello(Patient patient) {
        return "Hi, " + patient.getFirstName();
    }
}
