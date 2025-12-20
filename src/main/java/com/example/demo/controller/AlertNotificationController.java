package com.example.demo.controller;

import com.example.demo.model.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertNotificationController {

    private final AlertNotificationService alertService;

    public AlertNotificationController(AlertNotificationService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/send/{visitLogId}")
    public ResponseEntity<AlertNotification> send(@PathVariable Long visitLogId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(alertService.sendAlert(visitLogId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertNotification> get(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.getAlert(id));
    }

    @GetMapping
    public ResponseEntity<List<AlertNotification>> getAll() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }
}
