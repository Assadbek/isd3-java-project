package com.example.findtutor.controller;

import com.example.findtutor.model.DefaultSubject;
import com.example.findtutor.model.Tutor;
import com.example.findtutor.register.DefaultSubjectRepository;
import com.example.findtutor.register.TutorsRegister;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tutors")
public class TutorController {

    private final TutorsRegister tutorsRegister;
    private final DefaultSubjectRepository defaultSubjectRepository;

    @Autowired
    public TutorController(
            TutorsRegister tutorsRegister,
            DefaultSubjectRepository defaultSubjectRepository
    ) {
        this.tutorsRegister = tutorsRegister;
        this.defaultSubjectRepository = defaultSubjectRepository;
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
        val value = defaultSubjectRepository.findAll();
        System.out.println(value);
        model.addAttribute("defSubjects", value);

        return "create-tutor";
    }
    @PostMapping()
    public String createTutor(@RequestParam String name,
                            @RequestParam String surname) {
        Tutor newTutor = new Tutor();
        newTutor.setId(tutorsRegister.getTutors().size() + 1);
        newTutor.setName(name);
        newTutor.setName(surname);
        tutorsRegister.addTutor(newTutor);
        return "redirect:/tutors";
    }
}
