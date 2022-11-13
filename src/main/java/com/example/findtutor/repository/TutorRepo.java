package com.example.findtutor.repository;

import com.example.findtutor.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepo extends JpaRepository<Tutor, Long> {
}
