package com.ivan.mediappbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data includes the getters, setter, to String and equals and hashcode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Integer idPatient;
    private String firstName;
}
