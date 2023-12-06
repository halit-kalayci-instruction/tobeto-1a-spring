package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final BrandService brandService;
    // Her manager, yalnızca kendi entitysi için repository implementasyonu yapabilir!
    // Farklı bir entity ile çalışma gereğinde, o entitynin service'i ile çalışmalıdır.

    @Override
    public List<GetListCarResponse> getAll() {
        return carRepository.getAll();
    }

    @Override
    public void add(AddCarRequest request) {
        // Mapleme
        // Business Rule => İş Kuralı
        if(carRepository.existsCarByPlate(request.getPlate()))
        {
            throw new RuntimeException("Aynı plaka ile 2. araba eklenemez.");
        }

        Car car = new Car();
        car.setColor(request.getColor());
        car.setStatus("Available");
        car.setDailyPrice(request.getDailyPrice());
        car.setModelName(request.getModelName());
        car.setModelYear(request.getModelYear());
        car.setPlate(request.getPlate());
        // FK alanlar => FK alıp, veritabanından ilgili objeyi alarak set ederiz.
        Brand brand = brandService.getById(request.getBrandId());
        car.setBrand(brand);

        carRepository.save(car);
    }
}
