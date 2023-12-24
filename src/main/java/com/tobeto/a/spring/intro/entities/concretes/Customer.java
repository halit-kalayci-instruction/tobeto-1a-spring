package com.tobeto.a.spring.intro.entities.concretes;

import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "customers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;
}
