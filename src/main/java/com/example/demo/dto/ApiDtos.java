// package com.example.demo.dto;

// import java.time.LocalDate;
// import java.time.LocalDateTime;

// // A single container class that groups minimal DTOs required by typical controllers.
// // Tests in this project do not directly depend on DTOs, but these provide a clean API surface
// // if controllers are used manually.
// public class ApiDtos {

//     // Generic API response wrapper
//     public static class ApiResponse<T> {
//         private boolean success;
//         private String message;
//         private T data;

//         public ApiResponse() {}
//         public ApiResponse(boolean success, String message, T data) {
//             this.success = success;
//             this.message = message;
//             this.data = data;
//         }
//         public boolean isSuccess() { return success; }
//         public void setSuccess(boolean success) { this.success = success; }
//         public String getMessage() { return message; }
//         public void setMessage(String message) { this.message = message; }
//         public T getData() { return data; }
//         public void setData(T data) { this.data = data; }
//     }

//     // Auth DTOs
//     public static class LoginRequest {
//         private String username;
//         private String password;
//         public LoginRequest() {}
//         public String getUsername() { return username; }
//         public void setUsername(String username) { this.username = username; }
//         public String getPassword() { return password; }
//         public void setPassword(String password) { this.password = password; }
//     }

//     public static class LoginResponse {
//         private String token;
//         private Long userId;
//         private String role;
//         private String email;
//         public LoginResponse() {}
//         public LoginResponse(String token, Long userId, String role, String email) {
//             this.token = token; this.userId = userId; this.role = role; this.email = email;
//         }
//         public String getToken() { return token; }
//         public void setToken(String token) { this.token = token; }
//         public Long getUserId() { return userId; }
//         public void setUserId(Long userId) { this.userId = userId; }
//         public String getRole() { return role; }
//         public void setRole(String role) { this.role = role; }
//         public String getEmail() { return email; }
//         public void setEmail(String email) { this.email = email; }
//     }

//     // Visitor DTO
//     public static class VisitorDTO {
//         private Long id;
//         private String fullName;
//         private String phone;
//         private String idProofNumber;
//         private String email;
//         public VisitorDTO() {}
//         public Long getId() { return id; }
//         public void setId(Long id) { this.id = id; }
//         public String getFullName() { return fullName; }
//         public void setFullName(String fullName) { this.fullName = fullName; }
//         public String getPhone() { return phone; }
//         public void setPhone(String phone) { this.phone = phone; }
//         public String getIdProofNumber() { return idProofNumber; }
//         public void setIdProofNumber(String idProofNumber) { this.idProofNumber = idProofNumber; }
//         public String getEmail() { return email; }
//         public void setEmail(String email) { this.email = email; }
//     }

//     // Host DTO
//     public static class HostDTO {
//         private Long id;
//         private String hostName;
//         private String email;
//         private String phone;
//         public HostDTO() {}
//         public Long getId() { return id; }
//         public void setId(Long id) { this.id = id; }
//         public String getHostName() { return hostName; }
//         public void setHostName(String hostName) { this.hostName = hostName; }
//         public String getEmail() { return email; }
//         public void setEmail(String email) { this.email = email; }
//         public String getPhone() { return phone; }
//         public void setPhone(String phone) { this.phone = phone; }
//     }

//     // Appointment DTOs
//     public static class AppointmentRequest {
//         private Long visitorId;
//         private Long hostId;
//         private LocalDate appointmentDate;
//         private String purpose;
//         public AppointmentRequest() {}
//         public Long getVisitorId() { return visitorId; }
//         public void setVisitorId(Long visitorId) { this.visitorId = visitorId; }
//         public Long getHostId() { return hostId; }
//         public void setHostId(Long hostId) { this.hostId = hostId; }
//         public LocalDate getAppointmentDate() { return appointmentDate; }
//         public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
//         public String getPurpose() { return purpose; }
//         public void setPurpose(String purpose) { this.purpose = purpose; }
//     }

//     public static class AppointmentResponse {
//         private Long id;
//         private String status;
//         private LocalDate appointmentDate;
//         private String purpose;
//         private Long visitorId;
//         private Long hostId;
//         public AppointmentResponse() {}
//         public Long getId() { return id; }
//         public void setId(Long id) { this.id = id; }
//         public String getStatus() { return status; }
//         public void setStatus(String status) { this.status = status; }
//         public LocalDate getAppointmentDate() { return appointmentDate; }
//         public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
//         public String getPurpose() { return purpose; }
//         public void setPurpose(String purpose) { this.purpose = purpose; }
//         public Long getVisitorId() { return visitorId; }
//         public void setVisitorId(Long visitorId) { this.visitorId = visitorId; }
//         public Long getHostId() { return hostId; }
//         public void setHostId(Long hostId) { this.hostId = hostId; }
//     }

//     // VisitLog DTO
//     public static class VisitLogDTO {
//         private Long id;
//         private Long visitorId;
//         private Long hostId;
//         private String purpose;
//         private Boolean accessGranted;
//         private LocalDateTime checkInTime;
//         private LocalDateTime checkOutTime;
//         private Boolean alertSent;
//         public VisitLogDTO() {}
//         public Long getId() { return id; }
//         public void setId(Long id) { this.id = id; }
//         public Long getVisitorId() { return visitorId; }
//         public void setVisitorId(Long visitorId) { this.visitorId = visitorId; }
//         public Long getHostId() { return hostId; }
//         public void setHostId(Long hostId) { this.hostId = hostId; }
//         public String getPurpose() { return purpose; }
//         public void setPurpose(String purpose) { this.purpose = purpose; }
//         public Boolean getAccessGranted() { return accessGranted; }
//         public void setAccessGranted(Boolean accessGranted) { this.accessGranted = accessGranted; }
//         public LocalDateTime getCheckInTime() { return checkInTime; }
//         public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }
//         public LocalDateTime getCheckOutTime() { return checkOutTime; }
//         public void setCheckOutTime(LocalDateTime checkOutTime) { this.checkOutTime = checkOutTime; }
//         public Boolean getAlertSent() { return alertSent; }
//         public void setAlertSent(Boolean alertSent) { this.alertSent = alertSent; }
//     }

//     // Alert Notification DTO
//     public static class AlertNotificationDTO {
//         private Long id;
//         private Long visitLogId;
//         private String alertMessage;
//         private String sentTo;
//         private LocalDateTime sentAt;
//         public AlertNotificationDTO() {}
//         public Long getId() { return id; }
//         public void setId(Long id) { this.id = id; }
//         public Long getVisitLogId() { return visitLogId; }
//         public void setVisitLogId(Long visitLogId) { this.visitLogId = visitLogId; }
//         public String getAlertMessage() { return alertMessage; }
//         public void setAlertMessage(String alertMessage) { this.alertMessage = alertMessage; }
//         public String getSentTo() { return sentTo; }
//         public void setSentTo(String sentTo) { this.sentTo = sentTo; }
//         public LocalDateTime getSentAt() { return sentAt; }
//         public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
//     }
// }
