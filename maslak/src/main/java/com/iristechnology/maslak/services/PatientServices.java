package com.iristechnology.maslak.services;

import com.iristechnology.maslak.ecxeption.UserNotFoundException;
import com.iristechnology.maslak.model.Patient;
import com.iristechnology.maslak.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServices {

    private final PatientRepo patientRepo;
    @Autowired
    public PatientServices(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient addPatient(Patient patient){

        return  patientRepo.save(patient);
    }
    public List<Patient> findAllPatient(){
        return patientRepo.findAll();
    }
    public Patient updatePatient(Patient patient){
        return patientRepo.save(patient);

    }
    public void deletePatient(Long patientId){
        patientRepo.deletePatientById(patientId);
    }
    public  Patient findPatientById(Long id){
        return patientRepo.findPatientById(id).orElseThrow(() -> new UserNotFoundException("User by id"+"was not found"));
    }
    public Patient insertStatus(Patient patient){
        patient.status =0;
        return patientRepo.save(patient);


    }



    public Patient getPatientByStatus(Patient patient) {

        return patientRepo.save(patient);

    }
    public void getPatientByStatusWaiting(Long id) {
        patientRepo.getPatientByStatusWaiting(id);

    }
    public void getPatientByStatusDone(Long id) {
        patientRepo.getPatientByStatusDone(id);
    }

    public void getPatientByStatusReturn(Long id) {
        patientRepo.getPatientByStatusReturn(id);
    }

    public Optional<Patient> findPatientReturn(Long id){
        return patientRepo.findPatientByStatusReturn(id);
    }

    public Optional<Patient> findPatientWaiting(Long id){
        return patientRepo.findPatientByStatusWaiting(id);

    }

    public Optional<Patient> findPatientDone(Long id){
        return patientRepo.findPatientByStatusDone(id);
    }

}
