package com.example.findtutor.service.impl;

import com.example.findtutor.model.Subject;
import com.example.findtutor.model.TutorAmenities;
import com.example.findtutor.repository.SubjectRepo;
import com.example.findtutor.repository.TutorAmenitiesRepo;
import com.example.findtutor.service.TutorAmenitiesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TutorAmenitiesServiceImpl implements TutorAmenitiesService {

    private final TutorAmenitiesRepo tutorAmenitiesRepo;

    private final SubjectRepo subjectRepo;

    @Override
    public List<TutorAmenities> loadTutorAmenitiesList() {
        return tutorAmenitiesRepo.findAll();
    }

    @Override
    public TutorAmenities loadTutorAmenities(Long id) {
        return tutorAmenitiesRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @Override
    public List<TutorAmenities> loadTutorAmenitiesListByTutorId(Long id) {
        return tutorAmenitiesRepo.findAllByTutorId(id);
    }

    @Override
    public void saveTutorAmenities(TutorAmenities tutorAmenities) {
        tutorAmenitiesRepo.save(tutorAmenities);
    }

    @Override
    public void deleteTutorAmenities(Long id) {
        tutorAmenitiesRepo.deleteById(id);
    }

    @Override
    public List<Subject> loadSubjects() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject loadSubject(Long id) {
        return subjectRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @Override
    public void saveSubject(Subject subject) {
        subjectRepo.save(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepo.deleteById(id);
    }
}
