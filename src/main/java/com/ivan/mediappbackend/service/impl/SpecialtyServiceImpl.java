package com.ivan.mediappbackend.service.impl;

import com.ivan.mediappbackend.model.Specialty;
import com.ivan.mediappbackend.repo.IGenericRepo;
import com.ivan.mediappbackend.repo.ISpecialtyRepo;
import com.ivan.mediappbackend.service.ISpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl extends CRUDImpl<Specialty, Integer> implements ISpecialtyService {
    private final ISpecialtyRepo repo;

    @Override
    protected IGenericRepo<Specialty, Integer> getRepo() {
        return repo;
    }
}
