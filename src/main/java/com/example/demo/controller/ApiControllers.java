// package com.example.demo.controller;

// import com.example.demo.dto.ApiDtos.*;
// import com.example.demo.model.*;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api")
// public class ApiControllers {

//     @Autowired private VisitorService visitorService;
//     @Autowired private HostService hostService;
//     @Autowired private AppointmentService appointmentService;
//     @Autowired private VisitLogService visitLogService;
//     @Autowired private AlertNotificationService alertNotificationService;
//     @Autowired(required = false) private JwtUtil jwtUtil;

//     // Auth - simplified login using JwtUtil if present
//     @PostMapping("/auth/login")
//     public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest req) {
//         if (jwtUtil == null) {
//             // If JwtUtil isn't a bean in this context, return a dummy token
//             LoginResponse lr = new LoginResponse("DUMMY", 0L, "USER", null);
//             return ResponseEntity.ok(new ApiResponse<>(true, "ok", lr));
//         }
//         String token = jwtUtil.generateToken(req.getUsername(), "USER", 0L, null);
//         LoginResponse lr = new LoginResponse(token, 0L, "USER", null);
//         return ResponseEntity.ok(new ApiResponse<>(true, "ok", lr));
//     }

//     // Visitor endpoints
//     @PostMapping("/visitors")
//     public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor v) {
//         return ResponseEntity.ok(visitorService.createVisitor(v));
//     }

//     @GetMapping("/visitors")
//     public ResponseEntity<List<Visitor>> getAllVisitors() {
//         return ResponseEntity.ok(visitorService.getAllVisitors());
//     }

//     @GetMapping("/visitors/{id}")
//     public ResponseEntity<Visitor> getVisitor(@PathVariable Long id) {
//         return ResponseEntity.ok(visitorService.getVisitor(id));
//     }

//     // Host endpoints
//     @PostMapping("/hosts")
//     public ResponseEntity<Host> createHost(@RequestBody Host h) {
//         return ResponseEntity.ok(hostService.createHost(h));
//     }

//     @GetMapping("/hosts/{id}")
//     public ResponseEntity<Host> getHost(@PathVariable Long id) {
//         return ResponseEntity.ok(hostService.getHost(id));
//     }

//     // Appointment endpoints
//     @PostMapping("/appointments")
//     public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment a, @RequestParam Long visitorId, @RequestParam Long hostId) {
//         return ResponseEntity.ok(appointmentService.createAppointment(visitorId, hostId, a));
//     }

//     @GetMapping("/appointments/{id}")
//     public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
//         return ResponseEntity.ok(appointmentService.getAppointment(id));
//     }

//     @GetMapping("/appointments/host/{hostId}")
//     public ResponseEntity<List<Appointment>> byHost(@PathVariable Long hostId) {
//         return ResponseEntity.ok(appointmentService.getAppointmentsForHost(hostId));
//     }

//     @GetMapping("/appointments/visitor/{visitorId}")
//     public ResponseEntity<List<Appointment>> byVisitor(@PathVariable Long visitorId) {
//         return ResponseEntity.ok(appointmentService.getAppointmentsForVisitor(visitorId));
//     }

//     // Visit log endpoints
//     @PostMapping("/visitlogs/checkin")
//     public ResponseEntity<VisitLog> checkIn(@RequestParam Long visitorId, @RequestParam Long hostId, @RequestParam String purpose) {
//         return ResponseEntity.ok(visitLogService.checkInVisitor(visitorId, hostId, purpose));
//     }

//     @PostMapping("/visitlogs/{id}/checkout")
//     public ResponseEntity<VisitLog> checkOut(@PathVariable Long id) {
//         return ResponseEntity.ok(visitLogService.checkOutVisitor(id));
//     }

//     // Alert endpoints
//     @PostMapping("/alerts/send")
//     public ResponseEntity<AlertNotification> sendAlert(@RequestParam Long visitLogId) {
//         return ResponseEntity.ok(alertNotificationService.sendAlert(visitLogId));
//     }

//     @GetMapping("/alerts/{id}")
//     public ResponseEntity<AlertNotification> getAlert(@PathVariable Long id) {
//         return ResponseEntity.ok(alertNotificationService.getAlert(id));
//     }
// }
