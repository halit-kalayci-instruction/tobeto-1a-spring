package com.tobeto.a.spring.intro;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/persons")
public class PersonsController {
    // In-Memory DB
    private List<Person> personList = new ArrayList<>();


    @GetMapping
    public List<Person> getAll(){
        return personList;
    }

    @GetMapping("{id}")
    public void getById(@PathVariable int id){
        // Araştırma konusu
        // stream API

    }

    @PostMapping
    public String add(@RequestBody Person person)
    {
        personList.add(person);
        return "Eklendi";
    }
}
