package com.example.findtutor.service;

import com.example.findtutor.model.Tutor;
import com.example.findtutor.model.dto.TutorDetails;

import java.util.List;

public interface TutorService {

    List<Tutor> loadTutors();

    Tutor loadTutor(Long tutorId);

    TutorDetails loadTutorDetails(Long tutorId);

    void saveTutor(Tutor tutor);

    void deleteTutor(Long id);

}
