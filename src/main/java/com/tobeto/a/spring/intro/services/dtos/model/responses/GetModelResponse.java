package com.tobeto.a.spring.intro.services.dtos.model.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetModelResponse {
    private String name;
    private String brandName;
}
