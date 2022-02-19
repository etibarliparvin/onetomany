package com.example.demo.service.impl;

import com.example.demo.dao.CarRepository;
import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    @Override
    public CarResponse create(CarRequest request) {
        return null;
    }

    @Override
    public CarResponse findById(Long id) {
        return null;
    }

    @Override
    public List<CarResponse> findAll() {
        return null;
    }
}
