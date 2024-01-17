package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.concretes.User;
import com.tobeto.a.spring.intro.repositories.UserRepository;
import com.tobeto.a.spring.intro.services.abstracts.UserService;
import com.tobeto.a.spring.intro.services.dtos.user.requests.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void register(CreateUserRequest createUserRequest) {

        User user = User.builder()
                .username(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .authorities(createUserRequest.getRoles())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .build();
        userRepository.save(user);
    }
}
