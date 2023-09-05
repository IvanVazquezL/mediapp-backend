package com.ivan.mediappbackend.controller;

import com.ivan.mediappbackend.dto.MedicDTO;
import com.ivan.mediappbackend.model.Medic;
import com.ivan.mediappbackend.service.IMedicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/medics")
@RequiredArgsConstructor
public class MedicController {
    private final IMedicService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MedicDTO>> getAll() {
        List<MedicDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicDTO> getMedic(@PathVariable("id") Integer id) {
        Medic medic = service.findById(id);
        return new ResponseEntity<>(convertToDTO(medic), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody MedicDTO medicDTO) {
        Medic savedMedic = service.save(convertToEntity(medicDTO));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMedic.getIdMedic())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MedicDTO medicDTO) {
        Medic updatedMedic = service.update(convertToEntity(medicDTO), id);
        return new ResponseEntity<>(convertToDTO(updatedMedic), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<MedicDTO> findIdByHateoas(@PathVariable("id") Integer id) {
        EntityModel<MedicDTO> resource = EntityModel.of(convertToDTO(service.findById(id)));
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).getMedic(id));
        resource.add(link1.withRel("medic-info"));
        return resource;
    }

    private MedicDTO convertToDTO(Medic medic) {
        return modelMapper.map(medic, MedicDTO.class);
    }

    private Medic convertToEntity(MedicDTO medicDTO) {
        return modelMapper.map(medicDTO, Medic.class);
    }
}
