package com.ivan.mediappbackend.service.impl;

import com.ivan.mediappbackend.model.Exam;
import com.ivan.mediappbackend.repo.IExamRepo;
import com.ivan.mediappbackend.repo.IGenericRepo;
import com.ivan.mediappbackend.service.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl extends CRUDImpl<Exam, Integer> implements IExamService {
    private final IExamRepo repo;

    @Override
    protected IGenericRepo<Exam, Integer> getRepo() {
        return repo;
    }
}
