package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.concretes.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(User user);
}
