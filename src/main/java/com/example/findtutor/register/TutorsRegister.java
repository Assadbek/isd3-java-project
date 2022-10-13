package com.example.findtutor.register;

import com.example.findtutor.model.Publication;
import com.example.findtutor.model.Tutor;
import com.example.findtutor.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorsRegister {
    private final List<Tutor> tutors = new ArrayList<>();

    public TutorsRegister() {
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "Tutor" + i, "Tutor" + i);
            List<Publication> publicationList = List.of(
                    new Publication(i, "Publication" + 1),
                    new Publication(i, "Publication" + 2)
            );
            tutors.add(new Tutor(i, user.getId(), publicationList));
        }
    }

    public void addTutor(Tutor tutor) {
        tutors.add(tutor);
    }

    public List<Tutor> getTutors() {
        return tutors;
    }
}
