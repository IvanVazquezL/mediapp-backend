package com.ivan.mediappbackend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MedicDTO {
    @EqualsAndHashCode.Include
    private Integer idMedic;
    @NotNull
    @NotEmpty
    @Size(min=3)
    private String name;
    @NotNull
    @NotEmpty
    @Size(min=3)
    private String surname;
    @NotNull
    @NotEmpty
    @Size(min=3, max=12)
    private String license;
    @NotNull
    @NotEmpty
    private String photo;
}
