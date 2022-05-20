package com.todoExam.ToDo.controllers;

//import com.todoExam.ToDo.security.CustomeUserDetailSecurity;
import com.todoExam.ToDo.services.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HomeController {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping
    public String currentUserNameSimple(){
        Authentication authentication = authenticationFacade.getAuthention();
        return authentication.getName();
    }



}
