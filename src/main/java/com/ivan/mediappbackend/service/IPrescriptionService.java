package com.ivan.mediappbackend.service;

import com.ivan.mediappbackend.model.Exam;
import com.ivan.mediappbackend.model.Prescription;

import java.util.List;

public interface IPrescriptionService extends ICRUD<Prescription,Integer> {
    Prescription saveTransactional(Prescription prescription,  List<Exam> exams);
}
