package com.ivan.mediappbackend.controller;

import com.ivan.mediappbackend.dto.PrescriptionDTO;
import com.ivan.mediappbackend.dto.PrescriptionListExamDTO;
import com.ivan.mediappbackend.model.Exam;
import com.ivan.mediappbackend.model.Prescription;
import com.ivan.mediappbackend.service.IPrescriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {
    private final IPrescriptionService service;
    @Qualifier("prescriptionMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PrescriptionDTO>> getAll() {
        List<PrescriptionDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> getPrescription(@PathVariable("id") Integer id) {
        Prescription prescription = service.findById(id);
        return new ResponseEntity<>(convertToDTO(prescription), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PrescriptionListExamDTO prescriptionDTO) {
        Prescription prescription = this.convertToEntity(prescriptionDTO.getPrescription());
        //List<Exam> exams = prescriptionDTO.getListExam().stream().map(element -> modelMapper.map(element, Exam.class)).toList();
        List<Exam> exams = modelMapper.map(prescriptionDTO.getListExam(), new TypeToken<List<Exam>>(){}.getType());
        Prescription savedPrescription = service.saveTransactional(prescription, exams);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPrescription.getIdPrescription())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody PrescriptionDTO prescriptionDTO) {
        Prescription updatedPrescription = service.update(convertToEntity(prescriptionDTO), id);
        return new ResponseEntity<>(convertToDTO(updatedPrescription), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<PrescriptionDTO> findIdByHateoas(@PathVariable("id") Integer id) {
        EntityModel<PrescriptionDTO> resource = EntityModel.of(convertToDTO(service.findById(id)));
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).getPrescription(id));
        resource.add(link1.withRel("prescription-info"));
        return resource;
    }

    private PrescriptionDTO convertToDTO(Prescription prescription) {
        return modelMapper.map(prescription, PrescriptionDTO.class);
    }

    private Prescription convertToEntity(PrescriptionDTO prescriptionDTO) {
        return modelMapper.map(prescriptionDTO, Prescription.class);
    }
}
