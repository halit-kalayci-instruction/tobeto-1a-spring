package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.a.spring.intro.services.dtos.user.requests.LoginRequest;

public interface AuthService {
    void register(CreateUserRequest createUserRequest);
    String login(LoginRequest loginRequest);
}
