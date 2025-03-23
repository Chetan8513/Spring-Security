package com.webSecurity.security.controller;


import com.webSecurity.security.dto.AuthRequest;
import com.webSecurity.security.dto.RegisterRequest;
import com.webSecurity.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {




    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest){

        return userService.registerUser(registerRequest);




    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AuthRequest authRequest){

        return userService.verifiedUser(authRequest);

    }



}
