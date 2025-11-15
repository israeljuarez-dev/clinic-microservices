package com.microservice.doctor_service.repository;

import com.microservice.doctor_service.model.DoctorService;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DoctorServiceRepository extends ReactiveMongoRepository<DoctorService, String> {
}
