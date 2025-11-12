package com.microservice.doctor.model;


import com.microservice.doctor.enums.Specialty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Document(collection= "doctor")
public class Doctor {
    @Id
    private String id_doctor;
    private String name;
    private String last_name;
    private Long dni;
    private LocalDate birth_date;
    private String email;
    private Long phone_number;
    private String address;

    private Specialty specialty;
    private Set<LocalDateTime> available_appointments;
    private Double salary;
}
