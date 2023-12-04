package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Generic
// Generic Typelar Reference Type olarak belirtilmelidir.
public interface BrandRepository extends JpaRepository<Brand, Integer>
{
    // Select * from BRANDS WHERE Name=name


    // Derived Query Methods => Fonksiyon isimlendirmesi kuralları
    List<Brand> findByNameStartingWith(String name);

    // Derived Query Methodlar sadece veritabanı entity türüyle çalışır.

    // ********
    // Tablo ismi değil, entity ismi kullanılacak
    // Entity'e her zaman alias verilecek "Brand b"
    // Dinamik alanlarda fonksiyon parametresi okumak için :parametreAdi kalıbı kullanılacak.
    // JPQL içerisinde obje newlenebilir.
    // NEWlenen objeler tam yoluyla belirtilmelidir.
    // ********
    @Query("Select new com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name) " +
            "FROM Brand b WHERE b.name= :name") // SQL DEĞİL JPQL
    // Select b.name FROM Brand b Where b.name=BMW
    // Select b.name FROM Brand b Where b.name=Mercedes
    List<GetListBrandResponse> findByName(String name);
}
