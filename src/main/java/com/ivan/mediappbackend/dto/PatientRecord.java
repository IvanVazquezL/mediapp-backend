package com.ivan.mediappbackend.dto;
// Records simplify the creation of classes whose main purpose is to hold and transfer data
// By default, all components of a record are final, making instances of records immutable
// This immutability ensures that the data represented by a record cannot be changed once it's created.
// It doesn't have getters or setters
public record PatientRecord(
        int idPatient,
        String name,
        String surname,
        String dni,
        String address,
        String phone,
        String email
) { }
