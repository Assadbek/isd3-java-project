package com.example.findtutor.service;

import com.example.findtutor.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudent(Long id);

    void saveStudent(Student student);

    void deleteStudent(Long id);

}
