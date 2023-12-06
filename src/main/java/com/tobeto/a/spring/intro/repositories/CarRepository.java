package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse" +
            "( c.id, c.modelYear, c.modelName, new com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name)  ) " +
            "from Car c INNER JOIN c.brand b")
    List<GetListCarResponse> getAll();
    boolean existsCarByPlate(String plate);
}



