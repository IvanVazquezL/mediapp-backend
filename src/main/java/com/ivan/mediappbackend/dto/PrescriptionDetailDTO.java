package com.ivan.mediappbackend.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDetailDTO {
    @EqualsAndHashCode.Include
    private Integer idDetail;
    // Take the reference from the main prescription
    @JsonBackReference
    private PrescriptionDTO prescription;
    @NotNull
    private String diagnosis;
    @NotNull
    private String treatment;
}
