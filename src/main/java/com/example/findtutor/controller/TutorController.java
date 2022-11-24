package com.example.findtutor.controller;

import com.example.findtutor.model.Tutor;
import com.example.findtutor.service.impl.TutorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutors")
public class TutorController {

    @Autowired
    private KafkaTemplate<Long, Tutor> kafkaTemplate;

    private final TutorServiceImpl tutorsService;

    @Autowired
    public TutorController(TutorServiceImpl tutorsRegister) {
        this.tutorsService = tutorsRegister;
    }

    @GetMapping()
    public List<Tutor> getTutors() {
        return tutorsService.loadTutors();
    }

    @GetMapping("/{id}")
    public Tutor show(@PathVariable("id") Long id) {
        return tutorsService.loadTutor(id);
    }

    @PostMapping
    public void createTutor(@RequestBody Tutor tutor) {
        // save tutor
        System.out.println(tutor);

        ListenableFuture<SendResult<Long, Tutor>> future = kafkaTemplate.send("newTutor", 1L, tutor);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }

}
