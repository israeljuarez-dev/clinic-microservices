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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequest {
    private String id_doctor;

    @NotBlank(message = "Name can not be empty")
    private String name;

    @NotBlank(message = "Last name can not be empty")
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

    @NotNull(message="Specialty can not be null")
    private Specialty specialty;

    @NotNull(message = "Doctors must have at least one available appointment")
    private Set<LocalDateTime> available_appointments;

    @Max(value = 6)
    @NotNull(message = "Salary can not be null")
    private Double salary;
}
