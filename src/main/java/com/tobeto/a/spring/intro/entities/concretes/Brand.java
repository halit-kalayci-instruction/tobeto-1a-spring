package com.tobeto.a.spring.intro.entities.concretes;

import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="brands")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand extends BaseEntity {
    @Column(name="name")
    private String name;
    @Column(name="logo_path")
    private String logoPath;
}
