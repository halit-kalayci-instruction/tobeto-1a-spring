package com.tobeto.a.spring.intro.entities.abstracts;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

// Generic
@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="updated_date",nullable = true)
    private LocalDate updatedDate;

    @PrePersist
    private void beforeAdd() {
        createdDate = LocalDate.now();
    }

    @PreUpdate
    private void beforeUpdate() {
        updatedDate = LocalDate.now();
    }
}
