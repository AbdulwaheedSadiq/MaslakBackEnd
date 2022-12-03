package com.iristechnology.maslak.services;

import com.iristechnology.maslak.ecxeption.UserNotFoundException;
import com.iristechnology.maslak.model.Description;
import com.iristechnology.maslak.model.Patient;
import com.iristechnology.maslak.repository.DescriptionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DescriptionService {
    private final DescriptionRepo descriptionRepo;

    public DescriptionService(DescriptionRepo descriptionRepo) {
        this.descriptionRepo = descriptionRepo;
    }

    public Description addDescription(Description description){

        return  descriptionRepo.save(description);
    }
    public List<Description> findAllDescription(){
        return descriptionRepo.findAll();
    }
    public Description updateDescription(Description description){
        return descriptionRepo.save(description);

    }
    public void deleteDescription(Long id){
        descriptionRepo.deleteDescriptionById(id);
    }
    public  Description findDescriptionById(Long id){
        return descriptionRepo.findDescriptionById(id).orElseThrow(() -> new UserNotFoundException("User by id"+"was not found"));
    }
}
