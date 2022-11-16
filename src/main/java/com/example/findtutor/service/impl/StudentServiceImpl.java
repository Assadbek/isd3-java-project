package com.example.findtutor.service.impl;

import com.example.findtutor.model.Student;
import com.example.findtutor.repository.StudentRepo;
import com.example.findtutor.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

}
