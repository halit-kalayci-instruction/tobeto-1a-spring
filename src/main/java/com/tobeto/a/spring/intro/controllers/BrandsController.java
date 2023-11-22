package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    // final => sadece ctor'da ilgili değerin ataması yapılabileceğini söyler.
    private final BrandRepository brandRepository;
    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    // Dependency Injection

    // Spring IoC => DI Container


    @GetMapping
    public List<Brand> getAll() {
        // findAll => hazır bir JPArepository fonk.
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }

    @GetMapping("{id}")
    public BrandForDetailDto getById(@PathVariable int id){
        // Optional => Opsiyonel olarak Brand
        // verilen id ile bir veri varsa onu dön, yoksa exception fırlat
        // Entity => DTO
        Brand brand = brandRepository.findById(id).orElseThrow();
        BrandForDetailDto dto = new BrandForDetailDto();
        dto.setName(brand.getName());
        return dto;
    }

    // entitylerin direkt dışarıya açılması YANLIŞ ❌
    // DTO nesneleri kullanılmalıdır.


    @PostMapping
    public void add(@RequestBody BrandForAddDto brandForAddDto)
    {
        // DTO => Entity
        // Transfer
        Brand brand = new Brand();
        brand.setName(brandForAddDto.getName());
        // Mapping
        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        // exception fırlaması = bu satırın çalışmaması
        // bu satıra geldiyse, bu id ile bir veri vardır.
        brandRepository.delete(brandToDelete);
    }

    // update
}

// Request-Response Pattern
// Her request ve response özeldir, her birine DTO oluşturmak gerekir.

// AddBrandRequest dto
// AddBrandResponse dto

// GetBrandResponse
// GetAllBrandsResponse

@Data
class BrandForAddDto {
    private String name;
}
@Data
class BrandForDetailDto {
    private String name;
    private List<Car> cars;
}
// DTO Yapısı => Data Transfer Object
// Business-Services Katmanı

// DTO tanımlamaları, validasyon, iş kuralları, CCC (loglama,cacheleme), mapping