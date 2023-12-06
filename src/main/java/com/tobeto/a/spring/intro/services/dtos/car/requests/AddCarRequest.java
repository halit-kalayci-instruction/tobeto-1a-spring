package com.tobeto.a.spring.intro.services.dtos.car.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private int modelYear;
    private String modelName;
    private double dailyPrice;
    private String color;
    private String plate;
    private int brandId;
}
