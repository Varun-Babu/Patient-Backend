package com.example.patientapp_backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String healthHistory;
    private String doctor;

    public Patient() {
    }

    public Patient(int id, String name, String healthHistory, String doctor) {
        this.id = id;
        this.name = name;
        this.healthHistory = healthHistory;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

    public void setHealthHistory(String healthHistory) {
        this.healthHistory = healthHistory;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
