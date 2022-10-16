package com.example.findtutor.register;

import com.example.findtutor.model.Tutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorsRegister {
    private final List<Tutor> tutors = new ArrayList<>();

    public TutorsRegister() {
    }

    public void addTutor(Tutor tutor) {
        tutors.add(tutor);
    }

    public List<Tutor> getTutors() {
        return tutors;
    }

    public Tutor getTutor(int tutorId) {
        return tutors.get(tutorId);
    }
}
