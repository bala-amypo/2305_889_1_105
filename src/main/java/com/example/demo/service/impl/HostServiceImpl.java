package com.example.demo.service.impl;

import com.example.demo.model.Host;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.HostService;

import java.util.List;

public class HostServiceImpl implements HostService {
    // tests inject via Reflection
    private HostRepository hostRepository;

    public HostServiceImpl() {}
    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Host createHost(Host h) {
        return hostRepository.save(h);
    }

    @Override
    public Host getHost(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Host not found"));
    }

    @Override
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }
}