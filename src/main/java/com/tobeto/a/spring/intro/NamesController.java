package com.tobeto.a.spring.intro;

// EntitiesController

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ProductsController
// CategoriesController
@RestController
// tobeto.com/api/names
// tobeto.com/api/names/getById
// tobeto.com/api/names/getByFirstLetter
@RequestMapping("api/names")
public class NamesController
{
    // Mappinglerin aynı methoda sahip olanları, endpoint olarak spesifik bir alan ile
    // birbirinden ayrılmak zorundadır.
    @GetMapping
    public String get(){
        return "Merhaba Tobeto";
    }

    @GetMapping("get2")
    public String get2(){
        return "Merhaba Kodlamaio";
    }

    @PostMapping
    public String post(){
        return "Merhaba Tobeto, POST";
    }
}
