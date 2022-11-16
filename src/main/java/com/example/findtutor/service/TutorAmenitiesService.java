package com.example.findtutor.service;

import com.example.findtutor.model.Subject;
import com.example.findtutor.model.Tutor;
import com.example.findtutor.model.TutorAmenities;

import java.util.List;

public interface TutorAmenitiesService {

    List<TutorAmenities> loadTutorAmenitiesList();

    TutorAmenities loadTutorAmenities(Long id);

    List<TutorAmenities> loadTutorAmenitiesListByTutorId(Long id);

    void saveTutorAmenities(TutorAmenities tutorAmenities);

    void deleteTutorAmenities(Long id);

    List<Subject> loadSubjects();

    Subject loadSubject(Long id);

    void saveSubject(Subject subject);

    void deleteSubject(Long id);

}
