package com.example.demo.service.impl;

import com.example.demo.dao.PersonRepository;
import com.example.demo.dto.request.PersonRequest;
import com.example.demo.dto.response.PersonResponse;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public PersonResponse create(PersonRequest request) {
        return null;
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
