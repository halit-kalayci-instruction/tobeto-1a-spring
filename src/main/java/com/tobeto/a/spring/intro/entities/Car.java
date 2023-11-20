package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Repository, DAO, DAL
// Data Access Object
// Data Access Layer



// ORM => Object Relation Mapping
@Table(name = "cars")
@Entity
@Getter
@Setter
public class Car
{
    @Id
    @Column(name = "id") // name = kolon_adı
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // classın içindeki alanın adı

    @Column(name="model_year")
    private int modelYear;

    @Column(name="model_name")
    private String modelName;

    @Column(name="daily_price")
    private double dailyPrice;

    @Column(name="color")
    private String color;

    @Column(name="status")
    private String status;

    // TODO: İlişkisel Brand tablosunun alanlarını eklemek.
    @ManyToOne()
    @JoinColumn(name="brand_id")
    private Brand brand;
}
// 11:05