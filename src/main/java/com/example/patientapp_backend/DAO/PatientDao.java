package com.example.patientapp_backend.DAO;

import com.example.patientapp_backend.model.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends CrudRepository<Patient,Integer> {
    @Query(value = "SELECT `id`, `doctor`, `health_history`, `name` FROM `patients` WHERE `id` = :id",nativeQuery = true)
    List<Patient> SearchPatient(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM `patients` WHERE `id`=:id",nativeQuery = true)
    void deletePatient(@Param("id") Integer id);
}
