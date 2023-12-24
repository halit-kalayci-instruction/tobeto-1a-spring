package com.tobeto.a.spring.intro.controllers;
import com.tobeto.a.spring.intro.entities.concretes.Brand;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping()
    public List<Brand> getByName(@RequestParam String name){
        return brandService.getByName(name);
    }
    @GetMapping("dto")
    public List<GetListBrandResponse> getByNameDto(@RequestParam String name){
        return brandService.getByNameDto(name);
    }
}
