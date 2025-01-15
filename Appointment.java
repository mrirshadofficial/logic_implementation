package com.healthcare.model;

public class Appointment {
    private int appointmentId;
    private Patient patient;
    private String doctor;
    private String date;
    private String time;

    public Appointment(int appointmentId, Patient patient, String doctor, String date, String time) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getAppointmentId() {
        return appointmentId;
    }
}
