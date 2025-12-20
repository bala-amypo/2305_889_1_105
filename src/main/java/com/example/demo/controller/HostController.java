package com.example.demo.controller;

import com.example.demo.model.Host;
import com.example.demo.service.HostService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public ResponseEntity<Host> create(@RequestBody Host host) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hostService.createHost(host));
    }

    @GetMapping
    public ResponseEntity<List<Host>> getAll() {
        return ResponseEntity.ok(hostService.getAllHosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> get(@PathVariable Long id) {
        return ResponseEntity.ok(hostService.getHost(id));
    }
}
