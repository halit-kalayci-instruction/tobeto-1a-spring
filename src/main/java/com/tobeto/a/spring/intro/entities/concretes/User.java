package com.tobeto.a.spring.intro.entities.concretes;

import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
}
