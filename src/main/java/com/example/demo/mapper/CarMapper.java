package com.example.demo.mapper;

import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car toEntity(Long id, CarRequest request) {
        Car car = new Car();
        car.setModel(request.getModel());
        car.setPersonId(id);
        return car;
    }

    public CarResponse toResponse(Car car) {
        CarResponse response = new CarResponse();
        response.setId(car.getId());
        response.setModel(car.getModel());
        return response;
    }
}
