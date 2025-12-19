package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_logs")
public class VisitLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @Column(nullable = false)
    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    private String purpose;

    private Boolean accessGranted;

    @Column(nullable = false)
    private Boolean alertSent = false;

    @PrePersist
    protected void onCreate() {
        checkInTime = LocalDateTime.now();
    }

    public VisitLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Visitor getVisitor() { return visitor; }
    public void setVisitor(Visitor visitor) { this.visitor = visitor; }

    public Host getHost() { return host; }
    public void setHost(Host host) { this.host = host; }

    public LocalDateTime getCheckInTime() { return checkInTime; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }

    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public void setCheckOutTime(LocalDateTime checkOutTime) { this.checkOutTime = checkOutTime; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public Boolean getAccessGranted() { return accessGranted; }
    public void setAccessGranted(Boolean accessGranted) { this.accessGranted = accessGranted; }

    public Boolean getAlertSent() { return alertSent; }
    public void setAlertSent(Boolean alertSent) { this.alertSent = alertSent; }

    public VisitLog(Long id, Visitor visitor, Host host, LocalDateTime checkInTime, LocalDateTime checkOutTime,
            String purpose, Boolean accessGranted, Boolean alertSent) {
        this.id = id;
        this.visitor = visitor;
        this.host = host;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.purpose = purpose;
        this.accessGranted = accessGranted;
        this.alertSent = alertSent;
    }
    
}