package com.iristechnology.maslak.controller;

import com.iristechnology.maslak.model.Patient;
import com.iristechnology.maslak.services.PatientServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientServices patientServices;

    public PatientController(PatientServices patientServices){

        this.patientServices=patientServices;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatient(){
        List<Patient> patients= patientServices.findAllPatient();
        return  new ResponseEntity<>(patients, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable("id")Long id){
        Patient patient = patientServices.findPatientById(id);
        return  new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity <Patient > addPatient(@RequestBody Patient patient){
        Patient patient2 = patientServices.addPatient(patient);
        return new ResponseEntity<>(patient2,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public  ResponseEntity<Patient > updatePatient(@RequestBody Patient patient){
        Patient updatePatient = patientServices.updatePatient(patient);
        return new ResponseEntity<>(updatePatient,HttpStatus.OK);
    }
    @DeleteMapping (" /del-patient ")
    public  ResponseEntity<?> deletePatient(@PathVariable("id") Long id){
        patientServices.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/insert")
    public ResponseEntity<Patient> insertStatus(@RequestBody Patient patient){
         Patient patient1 = patientServices.insertStatus(patient);
        return new ResponseEntity<>(patient1,HttpStatus.CREATED);
    }



    @GetMapping("/statusWaiting/{id}")
    public ResponseEntity<?> changeStatus(@PathVariable ( "id") Long id) {
        patientServices. getPatientByStatusWaiting(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/statusDone/{id}")
    public ResponseEntity<?> changeStatusTODone(@PathVariable ( "id") Long id) {
        patientServices.getPatientByStatusDone(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/statusReturn/{id}")
    public ResponseEntity<?> changeStatusTOReturn(@PathVariable ( "id") Long id) {
        patientServices.getPatientByStatusReturn(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/findReturn/{id}")
    public ResponseEntity<Patient> findPatientReturnStatus(@PathVariable("id")Long id){
        Optional<Patient> patient = patientServices.findPatientReturn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findWait/{id}")
    public ResponseEntity<Patient> findPatientWaitStatus(@PathVariable("id")Long id){
        Optional<Patient> patient = patientServices.findPatientWaiting(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/findDone/{id}")
    public ResponseEntity<Patient> findPatientDoneStatus(@PathVariable("id")Long id){
        Optional<Patient> patient = patientServices.findPatientDone(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
