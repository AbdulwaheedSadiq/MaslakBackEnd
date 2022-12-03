package com.iristechnology.maslak.services;

import com.iristechnology.maslak.ecxeption.UserNotFoundException;
import com.iristechnology.maslak.model.Medicine;
import com.iristechnology.maslak.model.Patient;
import com.iristechnology.maslak.repository.MedicineRepo;
import com.iristechnology.maslak.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineService {
    private final MedicineRepo medicineRepo;
    @Autowired
    public MedicineService(MedicineRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }
    public Medicine addMedicine(Medicine medicine){

        return   medicineRepo.save(medicine);
    }
    public List<Medicine> findAllMedicine(){
        return medicineRepo.findAll();
    }
    public Medicine updateMedicine(Medicine medicine){
        return medicineRepo.save(medicine);

    }

    public  Medicine findMedicineById(Long id){
        return medicineRepo.findMedicineById(id).orElseThrow(() -> new UserNotFoundException("Medicine by id"+"was not found"));
    }
}
