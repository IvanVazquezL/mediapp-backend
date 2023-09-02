package com.ivan.mediappbackend.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
// It is necessary so we can use this class as a representation of the composed primary key
@Embeddable
@EqualsAndHashCode
// We implement Serializable because this class is not an entity but will need to be transformed into code for the DB
// Serialization is a mechanism of converting the state of an object into a byte stream.
public class PrescriptionExamPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="id_prescription", nullable = false)
    private Prescription prescription;
    @ManyToOne
    @JoinColumn(name="id_exam", nullable = false)
    private Exam exam;
}
