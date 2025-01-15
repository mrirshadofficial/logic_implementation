package com.healthcare.model;

public class Billing {
    private int billId;
    private int patientId;
    private double amount;

    public Billing(int billId, int patientId, double amount) {
        this.billId = billId;
        this.patientId = patientId;
        this.amount = amount;
    }

    public int getBillId() {
        return billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public double getAmount() {
        return amount;
    }
}
