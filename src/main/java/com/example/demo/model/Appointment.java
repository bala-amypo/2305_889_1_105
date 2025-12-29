package com.example.demo.model;

import java.time.LocalDate;

public class Appointment {
    private Long id;
    private LocalDate appointmentDate;
    private String purpose;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}