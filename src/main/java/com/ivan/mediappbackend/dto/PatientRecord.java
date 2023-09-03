package com.ivan.mediappbackend.dto;
// Records simplify the creation of classes whose main purpose is to hold and transfer data
public record PatientRecord(
        int idPatient,
        String name,
        String surname,
        String dni,
        String address,
        String phone,
        String email
) {

}
