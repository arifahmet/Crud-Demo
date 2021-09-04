package com.example.cruddemo.web.controller;

import com.example.cruddemo.service.StudentService;
import com.example.cruddemo.web.model.request.CreateStudentRequest;
import com.example.cruddemo.web.model.response.StudentQueryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<StudentQueryResponse>> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody CreateStudentRequest request){
        return ResponseEntity.ok(studentService.createStudent(request));
    }
}
