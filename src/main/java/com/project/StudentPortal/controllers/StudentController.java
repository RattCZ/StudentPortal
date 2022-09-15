package com.project.StudentPortal.controllers;

import java.util.List;
import java.util.Optional;

import com.project.StudentPortal.models.Student;
import com.project.StudentPortal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    public String getAll(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);


        return "students";
    }

    @RequestMapping(value="/getOne", method = {RequestMethod.GET})
    @ResponseBody
    public Optional<Student> getOne(Integer Id) {
        return studentService.getOne(Id);
    }

    @RequestMapping(value="/addNew", method = {RequestMethod.POST, RequestMethod.GET})
    public String addNew(Student student) {
        studentService.addNew(student);
        return "redirect:/students/getAll";
    }


    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Student student) {
        studentService.update(student);
        return "redirect:/students/getAll";
    }


    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        studentService.delete(Id);
        return "redirect:/students/getAll";
    }








}
