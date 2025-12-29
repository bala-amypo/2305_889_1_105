package com.example.demo.service.impl;

import com.example.demo.model.Host;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.HostService;

public class HostServiceImpl implements HostService {
    private HostRepository hostRepository;

    public HostServiceImpl() {}

    public Host createHost(Host host) {
        return hostRepository.save(host);
    }

    public Host getHost(Long id) {
        return hostRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Host not found"));
    }
}