package com.example.findtutor.controller;

import com.example.findtutor.model.Tutor;
import com.example.findtutor.service.impl.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutors")
public class TutorController {

    private final TutorService tutorsService;

    @Autowired
    public TutorController(TutorService tutorsRegister) {
        this.tutorsService = tutorsRegister;
    }

    @GetMapping()
    public List<Tutor> getTutors() {
        return tutorsService.getTutors();
    }

    @GetMapping("/{id}")
    public Tutor show(@PathVariable("id") Long id) {
        return tutorsService.getTutor(id);
    }

    @GetMapping("/create-tutor")
    public String create(Model model) {
        return "create-tutor";
    }

    @GetMapping("/{id}/edit")
    public String editTutor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tutor", tutorsService.getTutor(id));
        return "edit-tutor";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") Tutor tutor,
                         @PathVariable("id") Long id) {
        tutorsService.saveTutor(tutor);
        return "redirect:/tutors";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        tutorsService.deleteTutor(id);
        return "redirect:/tutors";
    }

    /*@PostMapping()
    public String createTutor(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam Long subject,
                              @RequestParam int age) {
        Tutor.TutorBuilder newTutor = Tutor.builder();
        newTutor.name(name)
                .surname(surname)
                .age(age);

        tutorsService.saveTutor(newTutor.build());
        return "redirect:/tutors";
    }*/
}
