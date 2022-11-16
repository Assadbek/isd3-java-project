package com.example.findtutor.repository;

import com.example.findtutor.model.TutorAmenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorAmenitiesRepo extends JpaRepository<TutorAmenities, Long> {

    List<TutorAmenities> findAllByTutorId(Long id);

}
