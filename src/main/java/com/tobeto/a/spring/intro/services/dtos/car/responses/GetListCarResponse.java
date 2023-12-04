package com.tobeto.a.spring.intro.services.dtos.car.responses;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetListCarResponse {
    private int id;
    private int modelYear;
    private String modelName;
    private GetListBrandResponse brand;
    //private Brand brand; // entityleri dışarı açma!
    //private String brandName;
    //private int brandId;
}
