package com.healthcare.model;

import javax.validation.constraints.*;

public class Appointment {
    @NotNull(message = "Appointment ID cannot be null")
    @Min(value = 1, message = "Appointment ID must be greater than 0")
    private int appointmentId;

    @NotNull(message = "Patient cannot be null")
    private Patient patient;

    @NotBlank(message = "Doctor name cannot be empty")
    private String doctor;

    @NotBlank(message = "Date cannot be empty")
    private String date;

    @NotBlank(message = "Time cannot be empty")
    private String time;

    public Appointment(int appointmentId, Patient patient, String doctor, String date, String time) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    // Getters and Setters
}
