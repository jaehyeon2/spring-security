package com.example.springsecurity.controller;

import com.example.springsecurity.Service.AuthService;
import com.example.springsecurity.dto.JwtRequestDto;
import com.example.springsecurity.dto.MemberSignupRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody JwtRequestDto request){
        try{
            return authService.login(request);
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public String singnup(@RequestBody MemberSignupRequestDto request){
        return authService.signup(request);
    }
}
