package com.tobeto.a.spring.intro.services.dtos.car.responses;

import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.model.responses.GetModelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListCarResponse {
    private int id;
    private int modelYear;
    private GetModelResponse model;
    private String colorName;
    //private Brand brand; // entityleri dışarı açma!
    //private String brandName;
    //private int brandId;
}
