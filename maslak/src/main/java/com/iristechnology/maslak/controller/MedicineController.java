package com.iristechnology.maslak.controller;

import com.iristechnology.maslak.model.Medicine;
import com.iristechnology.maslak.model.Patient;
import com.iristechnology.maslak.services.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/medicine")
public class MedicineController {
    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }
    @GetMapping("/all-medicine")
    public ResponseEntity<List<Medicine>> getAllPatient(){
        List<Medicine> medicine= medicineService.findAllMedicine();
        return  new ResponseEntity<>(medicine, HttpStatus.OK);
    }
    @GetMapping("/find-medicine/{id}")
    public ResponseEntity<Medicine> findPatientById(@PathVariable("id")Long id){
        Medicine medicine = medicineService.findMedicineById(id);
        return  new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    @PostMapping("/add-medicine")
    public  ResponseEntity <Medicine> addPatient(@RequestBody Medicine medicine){
        Medicine medicine1 = medicineService.addMedicine(medicine);
        return new ResponseEntity<>(medicine1,HttpStatus.CREATED);
    }
    @PutMapping("/upd-medicine")
    public  ResponseEntity<Medicine > updatePatient(@RequestBody Medicine medicine){
        Medicine updateMedicine = medicineService.updateMedicine(medicine);
        return new ResponseEntity<>(updateMedicine,HttpStatus.OK);
    }

}
