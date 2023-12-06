package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {
    private final CarService carService;

    @GetMapping
    public List<GetListCarResponse> getAll(){
        return carService.getAll();
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest addCarRequest){
        carService.add(addCarRequest);
    }
}
