package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;

import java.time.LocalDateTime;
import java.util.List;

public class AlertNotificationServiceImpl implements AlertNotificationService {

    // injected by reflection in tests
    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl() {}

    public AlertNotificationServiceImpl(AlertNotificationRepository alertRepository,
                                        VisitLogRepository visitLogRepository) {
        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalArgumentException("Alert already sent");
        }
        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setAlertMessage("Visitor check-in alert");
        String email = (log.getHost() != null) ? log.getHost().getEmail() : null;
        alert.setSentTo(email);
        alert.setSentAt(LocalDateTime.now());
        AlertNotification saved = alertRepository.save(alert);
        // mark visit log updated
        log.setAlertSent(true);
        visitLogRepository.save(log);
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