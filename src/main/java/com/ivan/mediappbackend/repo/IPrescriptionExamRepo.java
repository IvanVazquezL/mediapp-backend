package com.ivan.mediappbackend.repo;

import com.ivan.mediappbackend.model.PrescriptionExam;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPrescriptionExamRepo extends IGenericRepo<PrescriptionExam, Integer>{
    @Modifying
    @Query(value = "INSERT INTO prescription_exam(id_prescription, id_exam) VALUES (:idPrescription, :idExam)", nativeQuery = true)
    Integer saveExam(@Param("idPrescription") Integer idPrescription, @Param("idExam") Integer idExam);
}
