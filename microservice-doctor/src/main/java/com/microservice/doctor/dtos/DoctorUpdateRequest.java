package com.microservice.doctor.dtos;

import com.microservice.doctor.enums.Specialty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorUpdateRequest {

    private String name;
    private String last_name;

    @Digits(integer=8, fraction=0, message="Dni can not have more than 8 digits")
    private Long dni;

    @Past(message="Birth date can not be in the future")
    private LocalDate birth_date;

    @Email
    private String email;

    @Digits(integer=8, fraction=0, message="Phone number can not have more than 8 digits")
    private Long phone_number;

    @Size(max=200, message="Address must be up to 200 characters")
    private String address;

    private Specialty specialty;
    private Set<LocalDateTime> available_appointments;

    @DecimalMax(value = "6", message="Salary cannot exceed 6")
    private Double salary;
}
