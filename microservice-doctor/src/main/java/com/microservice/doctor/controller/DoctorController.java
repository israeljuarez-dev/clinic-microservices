package com.microservice.doctor.controller;

import com.microservice.doctor.dtos.DoctorDTO;
import com.microservice.doctor.dtos.DoctorRequest;
import com.microservice.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public Mono<ResponseEntity<DoctorDTO>> createDoctor(@RequestBody Mono<DoctorRequest> doctorRequestMono) {
        return doctorRequestMono
                .flatMap(doctorService::createDoctor) // todo lo hace el service
                .map(dto -> ResponseEntity.status(HttpStatus.CREATED).body(dto));
    }

}
