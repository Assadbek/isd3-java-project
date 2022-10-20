package com.example.findtutor.controller;

import com.example.findtutor.model.Tutor;
import com.example.findtutor.register.TutorsRegister;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tutors")
public class TutorController {

    private final TutorsRegister tutorsRegister;

    @Autowired
    public TutorController(
            TutorsRegister tutorsRegister
    ) {
        this.tutorsRegister = tutorsRegister;
    }

    @GetMapping()
    public String getTutors(Model model) {
        model.addAttribute("tutors", tutorsRegister.getTutors());
        return "tutors";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("tutor", tutorsRegister.getTutor(id));
        return "tutor";
    }

    @GetMapping("/create-tutor")
    public String create(Model model) {
        model.addAttribute("defSubjects", tutorsRegister.getDefaultSubjects());

        return "create-tutor";
    }
    @PostMapping()
    public String createTutor(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam int subject) {
        Tutor.TutorBuilder newTutor = Tutor.builder();
        newTutor.name(name)
                .surname(surname);

        tutorsRegister.saveTutor(newTutor.build());
        return "redirect:/tutors";
    }
}
