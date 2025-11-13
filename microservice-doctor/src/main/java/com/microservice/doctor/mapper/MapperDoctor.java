package com.microservice.doctor.mapper;

import com.microservice.doctor.dtos.DoctorDTO;
import com.microservice.doctor.dtos.DoctorRequest;
import com.microservice.doctor.dtos.DoctorUpdateRequest;
import com.microservice.doctor.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperDoctor {
    Doctor toEntity(DoctorRequest request);

    Doctor toEntityUpdate(DoctorUpdateRequest request);

    DoctorDTO toDto(Doctor doctor);

}
