package com.example.findtutor.register;

import com.example.findtutor.model.Publication;
import com.example.findtutor.model.Tutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorsRegister {
    private final List<Tutor> tutors = new ArrayList<>();

    public TutorsRegister() {
        for (int i = 0; i < 10; i++) {
            List<Publication> publications = List.of(
                    new Publication(i, "Publication" + 1),
                    new Publication(i, "Publication" + 2)
            );
            tutors.add(new Tutor(i, "TutorName" + i, "TutorSurname" + i, publications));
        }
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
