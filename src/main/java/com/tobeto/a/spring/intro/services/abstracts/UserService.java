package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.user.requests.CreateUserRequest;

public interface UserService {
    void register(CreateUserRequest createUserRequest);
}
