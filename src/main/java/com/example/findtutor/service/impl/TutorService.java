package com.example.findtutor.service.impl;

import com.example.findtutor.model.Tutor;
import com.example.findtutor.repository.TutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService implements com.example.findtutor.service.TutorService {
    private final TutorRepo tutorRepository;

    @Autowired
    public TutorService(
            TutorRepo tutorRepository
    ) {
        this.tutorRepository = tutorRepository;
    }

    public List<Tutor> getTutors() {
        return tutorRepository.findAll();
    }

    public Tutor getTutor(Long tutorId) {
        return this.tutorRepository.findById(tutorId).orElse(null);
    }

    public void saveTutor(Tutor tutor) {
        this.tutorRepository.save(tutor);
    }

    public void deleteTutor(Long id) {
        this.tutorRepository.deleteById(id);
    }

}
