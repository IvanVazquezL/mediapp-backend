package com.ivan.mediappbackend.service.impl;

import com.ivan.mediappbackend.model.Medic;
import com.ivan.mediappbackend.repo.IGenericRepo;
import com.ivan.mediappbackend.repo.IMedicRepo;
import com.ivan.mediappbackend.repo.IPatientRepo;
import com.ivan.mediappbackend.service.IMedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicServiceImpl extends CRUDImpl<Medic, Integer> implements IMedicService {
    private final IMedicRepo repo;

    @Override
    protected IGenericRepo<Medic, Integer> getRepo() {
        return repo;
    }
}
