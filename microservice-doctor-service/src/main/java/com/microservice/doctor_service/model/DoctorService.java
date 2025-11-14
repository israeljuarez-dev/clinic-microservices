package com.microservice.doctor_service.model;

import com.microservice.doctor_service.enums.ServiceType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection= "doctor_service")
public class DoctorService {
    @Id
    private String id_service;
    private String name;
    private String description;
    private Double price;
    private ServiceType serviceType;
    private String id_doctor;
    private Integer duration;

}
