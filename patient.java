package com.healthcare.model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private List<String> records;

    public Patient(int patientId, String name, int age, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.records = new ArrayList<>();
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public List<String> viewRecords() {
        return records;
    }

    public String getName() {
        return name;
    }

    public int getPatientId() {
        return patientId;
    }
}
