package com.tobeto.a.spring.intro.services.dtos.car.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @Min(value = 2005, message = "Model yılı en az 2005 olabilir.")
    private int modelYear;

    @NotBlank
    private String modelName;

    @Positive
    private double dailyPrice;

    @NotBlank
    private String color;

    @NotBlank
    @Length(min = 6)
    private String plate;

    @Positive
    private int brandId;
}
