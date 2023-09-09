package com.ivan.mediappbackend.controller;

import com.ivan.mediappbackend.dto.ExamDTO;
import com.ivan.mediappbackend.model.Exam;
import com.ivan.mediappbackend.service.IExamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {
    private final IExamService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ExamDTO>> getAll() {
        List<ExamDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> getExam(@PathVariable("id") Integer id) {
        Exam exam = service.findById(id);
        return new ResponseEntity<>(convertToDTO(exam), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ExamDTO examDTO) {
        Exam savedExam = service.save(convertToEntity(examDTO));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedExam.getIdExam())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ExamDTO examDTO) {
        Exam updatedExam = service.update(convertToEntity(examDTO), id);
        return new ResponseEntity<>(convertToDTO(updatedExam), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<ExamDTO> findIdByHateoas(@PathVariable("id") Integer id) {
        EntityModel<ExamDTO> resource = EntityModel.of(convertToDTO(service.findById(id)));
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).getExam(id));
        resource.add(link1.withRel("exam-info"));
        return resource;
    }

    private ExamDTO convertToDTO(Exam exam) {
        return modelMapper.map(exam, ExamDTO.class);
    }

    private Exam convertToEntity(ExamDTO examDTO) {
        return modelMapper.map(examDTO, Exam.class);
    }
}
