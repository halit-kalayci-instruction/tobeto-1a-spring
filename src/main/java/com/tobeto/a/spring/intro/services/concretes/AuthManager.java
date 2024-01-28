package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.core.services.JwtService;
import com.tobeto.a.spring.intro.entities.concretes.User;
import com.tobeto.a.spring.intro.repositories.UserRepository;
import com.tobeto.a.spring.intro.services.abstracts.AuthService;
import com.tobeto.a.spring.intro.services.abstracts.UserService;
import com.tobeto.a.spring.intro.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.a.spring.intro.services.dtos.user.requests.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(CreateUserRequest createUserRequest) {

        User user = User.builder()
                .username(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .authorities(createUserRequest.getRoles())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .build();
        userService.add(user);
    }
    @Override
    public String login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(loginRequest.getUsername());
        }

        throw new RuntimeException("Kullanıcı adı ya da şifre yanlış");
    }
}
