package com.tobeto.a.spring.intro;

// EntitiesController

import org.springframework.web.bind.annotation.*;

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


    //@RequestParam => Parametreden bilgi okuma
    @GetMapping
    public String get(@RequestParam String name, @RequestParam(required = false) String surname)
    {
        return "Merhaba " + name + " " + surname;
    }
    // PathVariable, QueryParam
    @GetMapping("get2")
    public String get2()
    {
        return "Merhaba Kodlamaio";
    }

    @PostMapping
    public String post()
    {
        return "Merhaba Tobeto, POST";
    }
}
