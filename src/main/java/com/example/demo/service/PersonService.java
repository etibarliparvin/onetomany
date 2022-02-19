package com.example.demo.service;

import com.example.demo.dto.request.PersonRequest;
import com.example.demo.dto.response.PersonResponse;

import java.util.List;

public interface PersonService {

    PersonResponse create(PersonRequest request);

    PersonResponse findById(Long id);

    List<PersonResponse> findAll();
}
