package com.example.demo.service;

import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;

import java.util.List;

public interface CarService {

    CarResponse create(CarRequest request);

    CarResponse findById(Long id);

    List<CarResponse> findAll();
}
