package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;

import java.util.List;

public interface CarService {
    List<GetListCarResponse> getAll();
}
