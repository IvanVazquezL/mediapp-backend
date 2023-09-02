package com.ivan.mediappbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// It tells where is the representation of the composed primary key
@IdClass(PrescriptionExamPK.class)
public class PrescriptionExam {
    @Id
    private Prescription prescription;
    @Id
    private Exam exam;
}
