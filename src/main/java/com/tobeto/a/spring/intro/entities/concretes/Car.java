package com.tobeto.a.spring.intro.entities.concretes;

import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cars")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {
    @Column(name="model_year")
    private short modelYear;

    @Column(name="plate")
    private String plate;

    @Column(name="min_findeks_rate")
    private short minFindeksRate;

    @Column(name="kilometer")
    private Long kilometer;

    @Column(name="daily_price")
    private Float dailyPrice;

    @Column(name="image_path")
    private String imagePath;

    @ManyToOne()
    @JoinColumn(name="model_id")
    private Model model;
}
