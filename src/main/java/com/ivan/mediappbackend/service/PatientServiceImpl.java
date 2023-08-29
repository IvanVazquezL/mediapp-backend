package com.ivan.mediappbackend.service;

import com.ivan.mediappbackend.model.Patient;
import com.ivan.mediappbackend.repo.IPatientRepo;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements  IPatientService{
    // Autowired annotation is used for automatic dependency injection.
    // To Uncouple code we use the interfaces instead of concrete classes
    private final IPatientRepo repo;

    public PatientServiceImpl(IPatientRepo repo) {
        this.repo = repo;
    }


    @Override
    public String sayHelloLogic(Patient patient) {
        return patient != null ? repo.sayHello(patient) : "The patient doesn't exist";
    }

}
