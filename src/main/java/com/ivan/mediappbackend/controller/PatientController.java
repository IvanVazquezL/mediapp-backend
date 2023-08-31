package com.ivan.mediappbackend.controller;

import com.ivan.mediappbackend.model.Patient;
import com.ivan.mediappbackend.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController to convert the class into a REST service
@RestController
//  @RequestMapping to assign an endpoint, it has to be a plural sustantive
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final IPatientService service;

    @GetMapping
    public List<Patient> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return service.save(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable("id") Integer id, @RequestBody Patient patient) {
        return service.update(patient, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
