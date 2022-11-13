package com.example.findtutor.service;

import com.example.findtutor.model.Tutor;

import java.util.List;

public interface TutorService {

    List<Tutor> getTutors();

    Tutor getTutor(Long tutorId);

    void saveTutor(Tutor tutor);

    void deleteTutor(Long id);

}
