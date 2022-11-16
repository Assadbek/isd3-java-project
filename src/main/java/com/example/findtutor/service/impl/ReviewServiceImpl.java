package com.example.findtutor.service.impl;

import com.example.findtutor.model.Review;
import com.example.findtutor.repository.ReviewRepo;
import com.example.findtutor.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    @Override
    public List<Review> getReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getReview(Long id) {
        return reviewRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @Override
    public void saveReview(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }

}
