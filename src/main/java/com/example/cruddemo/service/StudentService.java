package com.example.cruddemo.service;

import com.example.cruddemo.repository.StudentRepository;
import com.example.cruddemo.web.model.request.CreateStudentRequest;
import com.example.cruddemo.web.model.response.StudentQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentQueryResponse> getStudentById(String id) {
        return studentRepository.getStudentById(id).stream()
                .map(studentEntity -> StudentQueryResponse.of(studentEntity))
                .collect(Collectors.toList());
    }

    public String createStudent(CreateStudentRequest request) {
        return studentRepository.insertStudent(request);
    }
}
