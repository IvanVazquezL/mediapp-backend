package com.ivan.mediappbackend.controller;

import com.ivan.mediappbackend.dto.PatientDTO;
import com.ivan.mediappbackend.dto.PatientRecord;
import com.ivan.mediappbackend.model.Patient;
import com.ivan.mediappbackend.service.IPatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

// @RestController to convert the class into a REST service
@RestController
//  @RequestMapping to assign an endpoint, it has to be a plural sustantive
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final IPatientService service;
    // Dependency injection
    private final ModelMapper modelMapper;

    @GetMapping
    // Response Entity we use it to send the HttpStatus
    // Richardson Maturity Model Level 2
    public ResponseEntity<List<PatientDTO>> getAll() {
        List<PatientDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Integer id) {
        Patient patient = service.findById(id);
        return new ResponseEntity<>(convertToDTO(patient), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PatientDTO patientDTO) {
        Patient savedPatient = service.save(convertToEntity(patientDTO));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPatient.getIdPatient())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody PatientDTO patientDTO) {
        Patient updatedPatient = service.update(convertToEntity(patientDTO), id);
        return new ResponseEntity<>(convertToDTO(updatedPatient), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private PatientDTO convertToDTO(Patient patient) {
        return modelMapper.map(patient, PatientDTO.class);
    }

    private Patient convertToEntity(PatientDTO patientDTO) {
        return modelMapper.map(patientDTO, Patient.class);
    }
}
