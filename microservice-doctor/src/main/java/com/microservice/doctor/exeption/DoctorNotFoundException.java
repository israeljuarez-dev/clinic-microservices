package com.microservice.doctor.exeption;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String id_doctor) {
        super("Doctor with id: "+ id_doctor+ " not found.");
    }
}
