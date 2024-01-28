package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.AuthService;
import com.tobeto.a.spring.intro.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.a.spring.intro.services.dtos.user.requests.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody CreateUserRequest request) {
        authService.register(request);
    }

}
// 1:50