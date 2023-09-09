package com.ivan.mediappbackend.service.impl;

import com.ivan.mediappbackend.model.Exam;
import com.ivan.mediappbackend.model.Prescription;
import com.ivan.mediappbackend.repo.IGenericRepo;
import com.ivan.mediappbackend.repo.IPrescriptionExamRepo;
import com.ivan.mediappbackend.repo.IPrescriptionRepo;
import com.ivan.mediappbackend.service.IPrescriptionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl extends CRUDImpl<Prescription, Integer> implements IPrescriptionService {
    private final IPrescriptionRepo repo;
    private final IPrescriptionExamRepo PErepo;

    @Override
    protected IGenericRepo<Prescription, Integer> getRepo() {
        return repo;
    }
    @Transactional
    @Override
    public Prescription saveTransactional(Prescription prescription, List<Exam> exams) {
        repo.save(prescription); // saving of the master detail
        exams.forEach(exam -> PErepo.saveExam(prescription.getIdPrescription(), exam.getIdExam()));
        return prescription;
    }
}
