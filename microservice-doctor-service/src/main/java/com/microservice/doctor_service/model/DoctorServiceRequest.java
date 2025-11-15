package com.microservice.doctor_service.model;

import com.microservice.doctor_service.enums.ServiceType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorServiceRequest {
    private String id_service;
    @NotNull(message = "Name can not be empty")
    private String name;
    @Max(value= 200, message = "Description can not surpass 200 characters")
    private String description;
    @NotNull(message = "Price cannot be null")
    @Digits(integer = 4, fraction = 2, message = "Price can not have more than 4 digits and 2 decimals")
    private Double price;
    @NotNull(message = "Service type  can not be empty")
    private ServiceType serviceType;
    @NotNull(message = "Doctor ID cannot be null")
    private String id_doctor;
    @Max(value = 60, message = "A service can not last longer tha 60 minutes")
    private Integer duration;

}
