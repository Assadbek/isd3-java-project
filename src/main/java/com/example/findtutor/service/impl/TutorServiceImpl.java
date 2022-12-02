package com.example.findtutor.service.impl;

import com.example.findtutor.mapper.TutorMapper;
import com.example.findtutor.model.Tutor;
import com.example.findtutor.model.dto.TutorDetails;
import com.example.findtutor.repository.TutorRepo;
import com.example.findtutor.service.TutorAmenitiesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TutorServiceImpl implements com.example.findtutor.service.TutorService {
    private final TutorRepo tutorRepository;

    private final TutorAmenitiesService tutorAmenitiesService;

    public List<Tutor> loadTutors() {
        return tutorRepository.findAll();
    }

    public Tutor loadTutor(Long tutorId) {
        return this.tutorRepository.findById(tutorId)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @Override
    public TutorDetails loadTutorDetails(Long tutorId) {
        TutorMapper.toTutorDetails(loadTutor(tutorId), tutorAmenitiesService.loadTutorAmenitiesListByTutorId(tutorId));

        return null;
    }

    public void saveTutor(Tutor tutor) {
        this.tutorRepository.save(tutor);
    }

    public void deleteTutor(Long id) {
        this.tutorRepository.deleteById(id);
    }

}
