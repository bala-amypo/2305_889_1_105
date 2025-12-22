package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Appointments", description = "Appointment scheduling")
@SecurityRequirement(name = "Bearer Authentication")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/{visitorId}/{hostId}")
    @Operation(summary = "Create a new appointment")
    public ResponseEntity<Appointment> createAppointment(@PathVariable Long visitorId, 
                                                       @PathVariable Long hostId, 
                                                       @RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.createAppointment(visitorId, hostId, appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
    }

    @GetMapping("/host/{hostId}")
    @Operation(summary = "Get appointments for host")
    public ResponseEntity<List<Appointment>> getAppointmentsForHost(@PathVariable Long hostId) {
        List<Appointment> appointments = appointmentService.getAppointmentsForHost(hostId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/visitor/{visitorId}")
    @Operation(summary = "Get appointments for visitor")
    public ResponseEntity<List<Appointment>> getAppointmentsForVisitor(@PathVariable Long visitorId) {
        List<Appointment> appointments = appointmentService.getAppointmentsForVisitor(visitorId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get appointment by ID")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointment(id);
        return ResponseEntity.ok(appointment);
    }
}