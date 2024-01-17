package com.tobeto.a.spring.intro.services.dtos.user.requests;

import com.tobeto.a.spring.intro.entities.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String email;
    private String password;
    private String username;
    private List<Role> roles;
}
