package com.microservice.doctor.controller;

import com.microservice.doctor.dtos.DoctorDTO;
import com.microservice.doctor.dtos.DoctorRequest;
import com.microservice.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public Mono<ResponseEntity<DoctorDTO>> createDoctor(@RequestBody Mono<DoctorRequest> doctorRequestMono) {
        return doctorRequestMono
                .flatMap(doctorService::createDoctor)
                .map(dto -> ResponseEntity.status(HttpStatus.CREATED).body(dto));
    }

    @DeleteMapping("/delete/id_doctor")
    public Mono<ResponseEntity<Void>> deleteDoctor(@PathVariable String id_doctor) {
        return doctorService.deleteDoctor(id_doctor)
                .then(Mono.just(ResponseEntity.noContent().build())); // HTTP 204
    }

    @GetMapping("/id/{id_doctor}")
    public Mono<ResponseEntity<DoctorDTO>> getById(@PathVariable String id_doctor){
        return doctorService.findById(id_doctor)
                .map(ResponseEntity::ok);
    }



}
