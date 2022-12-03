package com.iristechnology.maslak.repository;

import com.iristechnology.maslak.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DescriptionRepo extends JpaRepository<Description,Long> {
    void deleteDescriptionById(Long id);

    Optional<Description> findDescriptionById(Long id);
}
