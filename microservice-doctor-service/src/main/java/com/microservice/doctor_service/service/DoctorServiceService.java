package com.microservice.doctor_service.service;

import com.microservice.doctor_service.dtos.DoctorServiceDTO;
import com.microservice.doctor_service.model.DoctorServiceRequest;
import com.microservice.doctor_service.repository.DoctorServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DoctorServiceService {
    @Autowired
    private DoctorServiceRepository repository;

    /// ---- Operaciones ABML ------

   
}
