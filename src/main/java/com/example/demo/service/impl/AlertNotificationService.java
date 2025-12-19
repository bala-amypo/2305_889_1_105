package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertNotificationService {
    
    private final AlertNotificationRepository alertNotificationRepository;
    private final VisitLogRepository visitLogRepository;

    public AlertNotificationService(AlertNotificationRepository alertNotificationRepository, 
                                  VisitLogRepository visitLogRepository) {
        this.alertNotificationRepository = alertNotificationRepository;
        this.visitLogRepository = visitLogRepository;
    }

    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog visitLog = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        if (alertNotificationRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new BadRequestException("Alert already sent");
        }

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(visitLog);
        alert.setSentTo(visitLog.getHost().getEmail());
        alert.setAlertMessage("Visitor " + visitLog.getVisitor().getFullName() + " has checked in");
        
        visitLog.setAlertSent(true);
        visitLogRepository.save(visitLog);
        
        return alertNotificationRepository.save(alert);
    }

    public AlertNotification getAlert(Long id) {
        return alertNotificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    public List<AlertNotification> getAllAlerts() {
        return alertNotificationRepository.findAll();
    }
}