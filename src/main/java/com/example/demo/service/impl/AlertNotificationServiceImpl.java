package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {
    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl() {}

    @Override
    public AlertNotification sendAlert(Long visitLogId) {
        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalArgumentException("Alert already sent for this visit");
        }
        
        VisitLog visitLog = visitLogRepository.findById(visitLogId)
            .orElseThrow(() -> new RuntimeException("VisitLog not found"));
            
        AlertNotification alert = new AlertNotification();
        alert.setVisitLogId(visitLogId);
        alert.setAlertMessage("Visitor " + visitLog.getVisitor().getFullName() + " has checked in");
        alert.setSentTo(visitLog.getHost().getEmail());
        alert.setSentAt(LocalDateTime.now());
        
        AlertNotification saved = alertRepository.save(alert);
        
        visitLog.setAlertSent(true);
        visitLogRepository.save(visitLog);
        
        return saved;
    }

    @Override
    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}