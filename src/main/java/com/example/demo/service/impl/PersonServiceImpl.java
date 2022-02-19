package com.example.demo.service.impl;

import com.example.demo.dao.CarRepository;
import com.example.demo.dao.PersonRepository;
import com.example.demo.dto.request.PersonRequest;
import com.example.demo.dto.response.PersonResponse;
import com.example.demo.entity.Person;
import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        request.getCars().stream().map(carMapper::toEntity).map(carRepository::save);
        return personMapper.toResponse(person);
    }

    @Override
    public PersonResponse findById(Long id) {
        return null;
    }

    @Override
    public List<PersonResponse> findAll() {
        return null;
    }
}
