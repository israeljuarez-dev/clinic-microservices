package com.microservice.doctor.service;


import com.microservice.doctor.dtos.DoctorDTO;
import com.microservice.doctor.dtos.DoctorRequest;
import com.microservice.doctor.mapper.MapperDoctor;
import com.microservice.doctor.model.Doctor;
import com.microservice.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private MapperDoctor mapperDoctor;

    /// ---- Operaciones ABML ----
    public Mono<DoctorDTO> createDoctor(DoctorRequest request) {
        Doctor doctor = mapperDoctor.toEntity(request);
        return doctorRepository.save(doctor)
                .map(mapperDoctor::toDto);
    }



}
