package com.ivan.mediappbackend.controller;

import com.ivan.mediappbackend.model.Patient;
import com.ivan.mediappbackend.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController to convert the class into a REST service
@RestController
//  @RequestMapping to assign an endpoint, it has to be a plural sustantive
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final IPatientService service;

    @GetMapping
    public String satHelloREST() {
        Patient p = new Patient(1, "Iban");
        return service.sayHelloLogic(p);
    }

    @GetMapping("/hello2")
    public String satHelloREST2() {
        Patient p = new Patient(2, "Iban");
        return service.sayHelloLogic(p);
    }
}
