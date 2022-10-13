package com.example.findtutor.controller;

import com.example.findtutor.register.TutorsRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tutors")
public class TutorController {

    private final TutorsRegister tutorsRegister;

    @Autowired
    public TutorController(TutorsRegister tutorsRegister) {
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

}
