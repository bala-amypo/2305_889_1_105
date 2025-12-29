package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import java.time.LocalDateTime;
import java.util.List;

public class AlertNotificationServiceImpl implements AlertNotificationService {
    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl() {}

    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog visitLog = visitLogRepository.findById(visitLogId)
            .orElseThrow(() -> new RuntimeException("VisitLog not found"));
        
        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalArgumentException("Alert already sent");
        }
        
        AlertNotification alert = new AlertNotification();
        alert.setAlertMessage("Visitor checked in");
        alert.setSentTo(visitLog.getHost().getEmail());
        alert.setSentAt(LocalDateTime.now());
        
        AlertNotification saved = alertRepository.save(alert);
        visitLogRepository.save(visitLog);
        
        return saved;
    }

    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    public List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}