package com.example.findtutor.service;

import com.example.findtutor.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviews();

    Review getReview(Long id);

    void saveReview(Review review);

    void deleteReview(Long id);

}
