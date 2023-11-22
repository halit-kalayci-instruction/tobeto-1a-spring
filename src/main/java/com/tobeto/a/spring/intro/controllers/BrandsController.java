package com.tobeto.a.spring.intro.controllers;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.concretes.BrandManager;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import org.springframework.web.bind.annotation.*;

// Single Responsibility
@RestController
@RequestMapping("api/brands")
public class BrandsController {
    // BAĞIMLILIKLAR DAİMA SOYUT NESNELER ÜZERİNDEN
    private BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }
}
