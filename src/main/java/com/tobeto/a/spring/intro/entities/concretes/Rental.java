package com.tobeto.a.spring.intro.entities.concretes;

import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="rentals")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Rental extends BaseEntity {
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;
    @Column(name="return_date")
    private LocalDate returnDate;
    @Column(name="start_kilometer")
    private Long startKilometer;
    @Column(name="end_kilometer")
    private Long endKilometer;

    @ManyToOne()
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;
}
