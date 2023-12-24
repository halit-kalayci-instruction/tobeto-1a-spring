package com.tobeto.a.spring.intro.services.dtos.car.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private short modelYear;
    private String plate;
    private short minFindeksRate;
    private Long kilometer;
    private Float dailyPrice;
    private String imagePath;

    private int modelId;
    private int colorId;
}
