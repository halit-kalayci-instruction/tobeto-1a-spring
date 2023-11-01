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
    // Query String
    @GetMapping
    public String get(@RequestParam String name, @RequestParam(required = false) String surname)
    {
        return "Merhaba " + name + " " + surname;
    }
    // PathVariable, QueryParam

    // /get2/halit

    // Tek parametrelerde path, çoklu parametrelerde RequestParam
    @GetMapping("{name}")
    public String get2(@PathVariable String name)
    {
        return "Merhaba " + name;
    }

    // JSON
    @PostMapping
    public String post(@RequestBody Person person)
    {
        return "Merhaba Tobeto, POST";
    }
}
