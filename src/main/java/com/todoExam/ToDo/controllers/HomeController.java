package com.todoExam.ToDo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Dashboard hello";
    }

    @GetMapping("/home")
    public String home() {
        return "HelloWord";
    }
}
