package com.example.demo.service.impl;

import com.example.demo.model.Host;
import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;
import com.example.demo.repository.HostRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitLogService;

import java.time.LocalDateTime;
import java.util.List;

public class VisitLogServiceImpl implements VisitLogService {

    // injected by reflection in tests
    private VisitLogRepository visitLogRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    public VisitLogServiceImpl() {}

    public VisitLogServiceImpl(VisitLogRepository visitLogRepository,
                               VisitorRepository visitorRepository,
                               HostRepository hostRepository) {
        this.visitLogRepository = visitLogRepository;
        this.visitorRepository = visitorRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        Host host = hostRepository.findById(hostId)
                .orElseThrow(() -> new RuntimeException("Host not found"));
        VisitLog log = new VisitLog();
        log.setVisitor(visitor);
        log.setHost(host);
        log.setPurpose(purpose);
        log.setAccessGranted(true);
        log.setCheckInTime(LocalDateTime.now());
        log.setAlertSent(false);
        return visitLogRepository.save(log);
    }

    @Override
    public VisitLog checkOutVisitor(Long visitLogId) {
        VisitLog existing = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
        if (existing.getCheckInTime() == null) {
            throw new IllegalStateException("Visitor not checked in");
        }
        existing.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(existing);
    }

    @Override
    public VisitLog getVisitLog(Long id) {
        return visitLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        return visitLogRepository.findByCheckOutTimeIsNull();
    }
}