package com.project.StudentPortal.controller;

import com.project.StudentPortal.model.Student;

import com.project.StudentPortal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {
        return studentRepository.findById(id).get();
    }

    @DeleteMapping("/remove/{id}")
    public boolean deleteStudent(@PathVariable("id") Integer id){
        if(!studentRepository.findById(id).equals(Optional.empty())){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") Integer id,
                                 @RequestBody Map<String, String> body){

        Student current = studentRepository.findById(id).get();
        current.setFirstName(body.get("firstname"));
        current.setSurname(body.get("surname"));
        current.setMail(body.get("mail"));
        studentRepository.save(current);
        return current;
    }

    @PostMapping("/add")
    public Student createStudent(@RequestBody Map<String, String> body){

        String firstname = body.get("firstname");
        String surname = body.get("surname");
        String mail = body.get("mail");
        Student newAddress = new Student(firstname, surname, mail);

        return studentRepository.save(newAddress);
    }
}