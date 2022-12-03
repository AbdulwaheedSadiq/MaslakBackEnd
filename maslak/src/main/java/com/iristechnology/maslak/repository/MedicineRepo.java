package com.iristechnology.maslak.repository;

import com.iristechnology.maslak.model.Medicine;

import com.iristechnology.maslak.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MedicineRepo extends JpaRepository<Medicine,Long> {




    Optional<Medicine> findMedicineById(Long id);

}
