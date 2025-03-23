package com.webSecurity.security.controller;


import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/user")
public class UserController {



    @GetMapping("/health")
    public String name(){

        return "application live on server";
    }

    public String userDashboard(){

        return "Entry in userDashboard";
    }

    @GetMapping("/session")
    public String session(HttpServletRequest http){

       return  http.getSession().getId();

    }
}
