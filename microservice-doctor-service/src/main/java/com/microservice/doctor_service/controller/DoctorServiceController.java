package com.microservice.doctor_service.controller;

import com.microservice.doctor_service.service.DoctorServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor-service")
public class DoctorServiceController {
    @Autowired
    private DoctorServiceService service;
}
