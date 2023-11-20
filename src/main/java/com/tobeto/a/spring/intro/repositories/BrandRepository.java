package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

// Generic
// Generic Typelar Reference Type olarak belirtilmelidir.
public interface BrandRepository extends JpaRepository<Brand, Integer>
{
}
