package com.example.demo.repository;

import com.example.demo.model.AlertNotification;
import java.util.List;
import java.util.Optional;

public interface AlertNotificationRepository {
    AlertNotification save(AlertNotification alert);
    Optional<AlertNotification> findById(Long id);
    List<AlertNotification> findAll();
    Optional<AlertNotification> findByVisitLogId(Long visitLogId);
}