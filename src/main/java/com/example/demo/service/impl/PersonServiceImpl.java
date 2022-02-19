package com.example.demo.service.impl;

import com.example.demo.dao.CarRepository;
import com.example.demo.dao.PersonRepository;
import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.request.PersonRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.dto.response.PersonResponse;
import com.example.demo.entity.Car;
import com.example.demo.entity.Person;
import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public PersonResponse create(PersonRequest request) {
        Person person = personRepository.save(personMapper.toEntity(request));
        List<CarRequest> cars1 = request.getCars();
        for (CarRequest c : cars1) {
            carRepository.save(carMapper.toEntity(person.getId(), c));
        }
//        carRepository.save(request.getCars().stream().map(a -> carMapper.toEntity(person.getId(), a)));
//        request.getCars().stream().map(a -> carMapper.toEntity(person.getId(), a)).map(carRepository::save);
        List<CarResponse> cars = carRepository.findAllByPersonId(person.getId()).stream()
                .map(carMapper::toResponse).collect(Collectors.toList());
        PersonResponse response = personMapper.toResponse(person);
        response.setCar(cars);
        return response;
    }

    @Override
    public PersonResponse findById(Long id) {
        Optional<Person> found = personRepository.findById(id);
        List<Car> cars = carRepository.findAllByPersonId(id);
        if (found.isPresent()) {
            PersonResponse response = personMapper.toResponse(found.get());
            response.setCar(cars.stream().map(carMapper::toResponse).collect(Collectors.toList()));
            return response;
        }
        return null;
    }

    @Override
    public List<PersonResponse> findAll() {
        return null;
    }
}
