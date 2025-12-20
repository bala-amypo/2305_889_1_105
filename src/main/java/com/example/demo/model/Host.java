package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hosts", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String hostName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String department;

    @NotBlank
    private String phone;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getHostName() { return hostName; }
    public void setHostName(String hostName) { this.hostName = hostName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
