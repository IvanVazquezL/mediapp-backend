package com.ivan.mediappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrescriptionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPrescriptionDetail;
    @ManyToOne
    @JoinColumn(name="id_prescription", nullable = false, foreignKey = @ForeignKey(name = "FK_PRESCRIPTION_DETAIL"))
    private Prescription prescription;

    @Column(length = 70, nullable = false)
    private String diagnosis;

    @Column(length = 300, nullable = false)
    private String treatment;
}
