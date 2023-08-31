package com.ivan.mediappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// @Data includes the getters, setter, to String
@Data
// Only the properties that we establish for the equal and hash code will work
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
// It establishes that the next class will be an entity in the DB
@Entity
// @Table(name="tbl_patient") it gives this name to the table instead of the name of the class
public class Patient {

    // We establish idPatient as the primary key
    @Id
    //  And it is going to autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // And also we are going to only use this property for the equals and has code methods
    @EqualsAndHashCode.Include
    private Integer idPatient;

    // @Column to specify restrictions for the properties
    @Column(length = 70, nullable = false)
    private String firstName;
    @Column(length = 70, nullable = false)
    private String lastName;
    @Column(length = 8, nullable = false)
    private String dni;
    @Column(length = 150, nullable = false)
    private String address;
    @Column(length = 10, nullable = false)
    private String phone;
    @Column(length = 55, nullable = false)
    private String email;
}
