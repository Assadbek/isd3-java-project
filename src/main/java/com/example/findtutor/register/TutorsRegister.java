package com.example.findtutor.register;

import com.example.findtutor.model.DefaultSubject;
import com.example.findtutor.model.Tutor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorsRegister {
    private final List<Tutor> tutors = new ArrayList<>();

    private final DefaultSubjectRepository defaultSubjectRepository;

    private final TutorRepository tutorRepository;

    @Autowired
    public TutorsRegister(
            DefaultSubjectRepository defaultSubjectRepository,
            TutorRepository tutorRepository
    ) {
        this.defaultSubjectRepository = defaultSubjectRepository;
        this.tutorRepository = tutorRepository;
    }

    public void addTutor(Tutor tutor) {
        tutors.add(tutor);
    }

    public List<Tutor> getTutors() {
        return tutorRepository.findAll();
    }

    public Tutor getTutor(int tutorId) {
        Integer id = tutorId;
        return null;
    }

    public void saveTutor(Tutor tutor) {
        this.tutorRepository.save(tutor);
    }

    public List<DefaultSubject> getDefaultSubjects() {
        return defaultSubjectRepository.findAll();
    }

}
