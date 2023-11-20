package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="brands")
@Entity
@Getter
@Setter
public class Brand {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    // sonsuz döngüden kaçınmak adına listeleri JSON'da göstermiyoruz.
    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Car> cars;
}
// one-to-many ilişkilerde list olan değişken
// @onetomany
// direkt class olan değişken @manytoone