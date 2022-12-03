package com.iristechnology.maslak.controller;

import com.iristechnology.maslak.model.Description;
import com.iristechnology.maslak.model.Patient;
import com.iristechnology.maslak.services.DescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/description")
public class DescriptionController {
    private final DescriptionService descriptionService;

    public DescriptionController(DescriptionService descriptionService) {
        this. descriptionService =  descriptionService;
    }
    @GetMapping("/all-description")
    public ResponseEntity<List<Description>> getAllDescription(){
        List<Description> descriptions=  descriptionService.findAllDescription();
        return  new ResponseEntity<>(descriptions, HttpStatus.OK);
    }
    @GetMapping("/find-description/{id}")
    public ResponseEntity<Description> findPatientById(@PathVariable("id")Long id){
        Description description =  descriptionService.findDescriptionById(id);
        return  new ResponseEntity<>(description, HttpStatus.OK);
    }

    @PostMapping("/add-description")
    public  ResponseEntity <Description > addDescription(@RequestBody Description description){
        Description description1 =  descriptionService.addDescription(description);
        return new ResponseEntity<>(description1,HttpStatus.CREATED);
    }
    @PutMapping("/update-description")
    public  ResponseEntity<Description > updateDescription(@RequestBody Description description){
        Description updateDescription =  descriptionService.updateDescription(description);
        return new ResponseEntity<>(updateDescription,HttpStatus.OK);
    }
    @DeleteMapping (" /del-description ")
    public  ResponseEntity<?> deletePatient(@PathVariable("id") Long id){
        descriptionService.deleteDescription(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
