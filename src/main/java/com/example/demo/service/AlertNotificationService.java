package com.example.demo.service;

import com.example.demo.model.AlertNotification;
import java.util.*;

public interface AlertNotificationService {
    AlertNotification sendAlert(Long visitLogId);
    AlertNotification getAlert(Long id);
    List<AlertNotification> getAllAlerts();
}