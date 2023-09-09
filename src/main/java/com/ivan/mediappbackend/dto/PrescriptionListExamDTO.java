package com.ivan.mediappbackend.dto;

import com.ivan.mediappbackend.model.Prescription;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionListExamDTO {
    @NotNull
    private PrescriptionDTO prescription;
    @NotNull
    private List<ExamDTO> listExam;
}
