package com.ivan.mediappbackend.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ivan.mediappbackend.model.PrescriptionDetail;
import com.ivan.mediappbackend.model.Specialty;
import jakarta.validation.constraints.NotNull;
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
public class PrescriptionDTO {
    private Integer idPrescription;
    @NotNull
    private PatientDTO patient;
    @NotNull
    private MedicDTO medic;
    @NotNull
    private SpecialtyDTO specialty;
    @NotNull
    private String prescriptionNumber;
    @NotNull
    private LocalDateTime prescriptionDate;
    // Reference at class level
    // PrescriptionDTO has the main prescription
    @JsonManagedReference
    @NotNull
    private List<PrescriptionDetailDTO> details;
}
