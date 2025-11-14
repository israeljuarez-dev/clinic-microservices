package com.microservice.doctor_service.service;

import com.microservice.doctor_service.repository.DoctorServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceService {
    @Autowired
    private DoctorServiceRepository repository;
}
