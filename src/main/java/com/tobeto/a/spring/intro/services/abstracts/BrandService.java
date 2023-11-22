package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;

public interface BrandService {
    void add(AddBrandRequest request);
}
