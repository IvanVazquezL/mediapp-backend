package com.ivan.mediappbackend.controller;

import com.ivan.mediappbackend.dto.SpecialtyDTO;
import com.ivan.mediappbackend.model.Specialty;
import com.ivan.mediappbackend.service.ISpecialtyService;
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
@RequestMapping("/specialties")
@RequiredArgsConstructor
public class SpecialtyController {
    private final ISpecialtyService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<SpecialtyDTO>> getAll() {
        List<SpecialtyDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> getSpecialty(@PathVariable("id") Integer id) {
        Specialty specialty = service.findById(id);
        return new ResponseEntity<>(convertToDTO(specialty), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SpecialtyDTO specialtyDTO) {
        Specialty savedSpecialty = service.save(convertToEntity(specialtyDTO));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSpecialty.getIdSpecialty())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody SpecialtyDTO specialtyDTO) {
        Specialty updatedSpecialty = service.update(convertToEntity(specialtyDTO), id);
        return new ResponseEntity<>(convertToDTO(updatedSpecialty), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<SpecialtyDTO> findIdByHateoas(@PathVariable("id") Integer id) {
        EntityModel<SpecialtyDTO> resource = EntityModel.of(convertToDTO(service.findById(id)));
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).getSpecialty(id));
        resource.add(link1.withRel("specialty-info"));
        return resource;
    }

    private SpecialtyDTO convertToDTO(Specialty specialty) {
        return modelMapper.map(specialty, SpecialtyDTO.class);
    }

    private Specialty convertToEntity(SpecialtyDTO specialtyDTO) {
        return modelMapper.map(specialtyDTO, Specialty.class);
    }
}
