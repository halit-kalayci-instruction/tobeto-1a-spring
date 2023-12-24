package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.core.utilities.mapper.services.ModelMapperService;
import com.tobeto.a.spring.intro.entities.concretes.Brand;
import com.tobeto.a.spring.intro.entities.concretes.Car;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final BrandService brandService;
    private final ModelMapperService modelMapperService;
    // Her manager, yalnızca kendi entitysi için repository implementasyonu yapabilir!
    // Farklı bir entity ile çalışma gereğinde, o entitynin service'i ile çalışmalıdır.

    @Override
    public List<GetListCarResponse> getAll() {
        List<Car> cars = carRepository.findAll();

        List<GetListCarResponse> response = cars.stream()
                .map((car) -> modelMapperService.forResponse().map(car, GetListCarResponse.class))
                .toList();
        //

        return response;
    }

    //10:10
    @Override
    public void add(AddCarRequest request) {


        Car car = modelMapperService.forRequest().map(request, Car.class);

        //carRepository.save(car);


    }
}
