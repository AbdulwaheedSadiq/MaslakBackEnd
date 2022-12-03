package com.iristechnology.maslak.repository;

import com.iristechnology.maslak.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    void deletePatientById(Long id);

    Optional<Patient> findPatientById(Long id);

    @Transactional
    @Modifying
    @Query(value="UPDATE patient SET status=\"1\" WHERE id=?1",nativeQuery = true)
    void getPatientByStatusWaiting  ( Long id);

    @Transactional
    @Modifying
    @Query(value="UPDATE patient SET status=\"2\" WHERE id=?1",nativeQuery = true)
    void getPatientByStatusDone( Long id);
    @Transactional
    @Modifying
    @Query(value="UPDATE patient SET status=\"3\" WHERE id=?1",nativeQuery = true)
    void getPatientByStatusReturn( Long id);


    @Query(value="SELECT * FROM `patient` WHERE STATUS = 3 ",nativeQuery = true)
    Optional<Patient> findPatientByStatusReturn(Long id);

    @Query(value="SELECT * FROM `patient` WHERE STATUS = 1 ",nativeQuery = true)
    Optional<Patient> findPatientByStatusWaiting(Long id);


    @Query(value="SELECT * FROM `patient` WHERE STATUS = 2",nativeQuery = true)
    Optional<Patient> findPatientByStatusDone(Long id);

}
