package com.example.findtutor.repository;

import com.example.findtutor.model.Review;
import com.example.findtutor.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}
