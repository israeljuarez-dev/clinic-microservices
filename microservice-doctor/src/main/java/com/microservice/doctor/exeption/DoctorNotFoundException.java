package com.microservice.doctor.exeption;

public class DoctorNotFoundException extends RuntimeException {
  public DoctorNotFoundException(String message) {
    super(message);
  }
}
