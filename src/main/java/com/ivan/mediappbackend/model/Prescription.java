package com.ivan.mediappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPrescription;

    // We use @ManyToOne to represent that a patient can have many prescriptions
    // Also it is better to keep the patient instance instead of just the patientId
    // This way we can store more of the patient's info instead of just the id
    @ManyToOne
    // We use @JoinColumn to represent the column that will be the foreignKey
    @JoinColumn(name="id_patient", nullable = false, foreignKey = @ForeignKey(name = "FK_PRESCRIPTION_PATIENT"))
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="id_medic", nullable = false, foreignKey = @ForeignKey(name = "FK_PRESCRIPTION_MEDIC"))
    private Medic medic;

    @ManyToOne
    @JoinColumn(name="id_specialty", nullable = false, foreignKey = @ForeignKey(name = "FK_PRESCRIPTION_SPECIALTY"))
    private Specialty specialty;

    @Column(length=5, nullable=false)
    private String prescriptionNumber;

    @Column(nullable=false)
    private LocalDateTime prescriptionDate;

    // Bidirectional relationship with PrescriptionDetail
    // mappedby is how they are related, they are related by the prescription property in details
    // cascade -> ALL, anything that happens to the father(Prescription) also will happen to the son(details)
    // orphanRemoval, if i want to delete a detail i only delete it instead of all of them
    // FetchType -> eager, brings the subelements with all its data
    // ->lazy, brings the elements with some data
    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PrescriptionDetail> details;
}
