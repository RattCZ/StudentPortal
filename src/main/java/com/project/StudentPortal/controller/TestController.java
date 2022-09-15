package com.project.StudentPortal.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {

    @RequestMapping("/index")
    public String welcome(){ //function name cannot be the same as the request mapping.
        return "index.html";
    }

    @RequestMapping("/update")
    public String welcome2(){ //function name cannot be the same as the request mapping.
        return "UpdateStudent.html";
    }



}