package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
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
    public Brand getById(@PathVariable int id){
        // Optional => Opsiyonel olarak Brand
        // verilen id ile bir veri varsa onu dön, yoksa exception fırlat
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
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
// http://localhost:8080/api/brands GET

// JSON Infinite Recursion