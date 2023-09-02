
package com.ivan.mediappbackend.service.impl;

import com.ivan.mediappbackend.model.Patient;
import com.ivan.mediappbackend.repo.IGenericRepo;
import com.ivan.mediappbackend.repo.IPatientRepo;
import com.ivan.mediappbackend.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//  @RequiredArgsConstructor is used to have constructors with final properties
@RequiredArgsConstructor
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements IPatientService {
    private final IPatientRepo repo;

    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }


}

