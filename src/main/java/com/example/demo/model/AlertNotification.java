package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "alert_notification",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "visit_log_id")
    }
)
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    @OneToOne
    @JoinColumn(name = "visit_log_id", nullable = false, unique = true)
    private VisitLog visitLog;

    @Column(nullable = false)
    private String sentTo;

    @Column(nullable = false)
    private String alertMessage;

    @Column(nullable = false)
    private LocalDateTime sentAt;

   
    @PrePersist
    public void onSend() {
        this.sentAt = LocalDateTime.now();
    }

   
    public Long getId() {
        return id;
    }

    public VisitLog getVisitLog() {
        return visitLog;
    }

    public void setVisitLog(VisitLog visitLog) {
        this.visitLog = visitLog;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
