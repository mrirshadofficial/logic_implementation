package com.healthcare.model;

import javax.validation.constraints.*;

public class Patient {
    @NotNull(message = "Patient ID cannot be null")
    @Min(value = 1, message = "Patient ID must be greater than 0")
    private int patientId;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 0, message = "Age must be a positive number")
    private int age;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    public Patient(int patientId, String name, int age, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters
}
