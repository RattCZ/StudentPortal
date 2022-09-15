package com.project.StudentPortal.controller;

import com.project.StudentPortal.model.Student;
import com.project.StudentPortal.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return mySqlRepository.findAll();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {
        return mySqlRepository.findById(id).get();
    }

    @DeleteMapping("/remove/{id}")
    public boolean deleteStudent(@PathVariable("id") Integer id){
        if(!mySqlRepository.findById(id).equals(Optional.empty())){
            mySqlRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") Integer id,
                                 @RequestBody Map<String, String> body){

        Student current = mySqlRepository.findById(id).get();
        current.setFirstName(body.get("firstname"));
        current.setSurname(body.get("surname"));
        current.setMail(body.get("mail"));
        mySqlRepository.save(current);
        return current;
    }

    @PostMapping("/add")
    public Student createStudent(@RequestBody Map<String, String> body){

        String firstname = body.get("firstname");
        String surname = body.get("surname");
        String mail = body.get("mail");
        Student newAddress = new Student(firstname, surname, mail);

        return mySqlRepository.save(newAddress);
    }
}
