package com.project.StudentPortal.controller;

import com.project.StudentPortal.model.Student;
import com.project.StudentPortal.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/get-all-students")
    public List<Student> getAllStudents() {
        return mySqlRepository.findAll();
    }

}
