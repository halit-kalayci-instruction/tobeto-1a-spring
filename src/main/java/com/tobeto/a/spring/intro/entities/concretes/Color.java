package com.tobeto.a.spring.intro.entities.concretes;

import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="colors")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color extends BaseEntity {
    @Column(name="name")
    private String name;
    @Column(name="code")
    private String code;

    @OneToMany(mappedBy = "color")
    private List<Car> cars;

}
