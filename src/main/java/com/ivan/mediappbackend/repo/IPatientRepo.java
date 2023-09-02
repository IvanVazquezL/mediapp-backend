package com.ivan.mediappbackend.repo;

import com.ivan.mediappbackend.model.Patient;
// JpaRepository makes all the CRUD for us
public interface IPatientRepo extends IGenericRepo<Patient, Integer> {
}
