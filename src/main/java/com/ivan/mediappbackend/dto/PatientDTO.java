package com.ivan.mediappbackend.dto;

// DTO -> It's a design pattern used in software development to transfer data between different parts of
// an application or between different applications.

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// Reducing Data -> DTOs can include a subset of the data from the original object. For example, if an
// entity class in a database has ten fields, you might create a DTO with only five of those fields to
// reduce data transfer overhead.
@Data

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    @EqualsAndHashCode.Include
    private Integer idPatient;
    @NotNull
    @NotEmpty
    @Size(min=3, max=70, message="{firstName.Size}")
    private String firstName;
    @NotNull
    @NotEmpty
    @Size(min=3, max=70, message="{lastName.Size}")
    private String lastName;
    private String dni;
    private String address;
    @Pattern(regexp = "[0-9]+")
    private String phone;
    @Email
    private String email;
}
