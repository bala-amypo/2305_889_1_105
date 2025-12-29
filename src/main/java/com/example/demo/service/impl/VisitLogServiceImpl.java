package com.example.demo.service.impl;

import com.example.demo.model.VisitLog;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.VisitLogService;
import java.time.LocalDateTime;
import java.util.List;

public class VisitLogServiceImpl implements VisitLogService {
    private VisitLogRepository visitLogRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    public VisitLogServiceImpl() {}

    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        var visitor = visitorRepository.findById(visitorId)
            .orElseThrow(() -> new RuntimeException("Visitor not found"));
        var host = hostRepository.findById(hostId)
            .orElseThrow(() -> new RuntimeException("Host not found"));
        
        VisitLog visitLog = new VisitLog();
        visitLog.setVisitor(visitor);
        visitLog.setHost(host);
        visitLog.setCheckInTime(LocalDateTime.now());
        visitLog.setAccessGranted(true);
        
        return visitLogRepository.save(visitLog);
    }

    public VisitLog checkOutVisitor(Long visitLogId) {
        VisitLog visitLog = visitLogRepository.findById(visitLogId)
            .orElseThrow(() -> new RuntimeException("VisitLog not found"));
        
        if (visitLog.getCheckInTime() == null) {
            throw new IllegalStateException("Visitor not checked in");
        }
        
        visitLog.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(visitLog);
    }

    public List<VisitLog> getActiveVisits() {
        return visitLogRepository.findByCheckOutTimeIsNull();
    }

    public VisitLog getVisitLog(Long id) {
        return visitLogRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("VisitLog not found"));
    }
}