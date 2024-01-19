package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.core.services.JwtService;
import com.tobeto.a.spring.intro.entities.concretes.User;
import com.tobeto.a.spring.intro.repositories.UserRepository;
import com.tobeto.a.spring.intro.services.abstracts.UserService;
import com.tobeto.a.spring.intro.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.a.spring.intro.services.dtos.user.requests.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    // 10.25
    @Override
    public String login(LoginRequest loginRequest) {
        return "";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }
}
