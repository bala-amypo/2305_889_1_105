package com.example.demo.model;

import jakarta.persistence.*;
public class Visitor{
    @Id
    private Long id;
    private String name;
    private String  email;
    private String phonenumber;
    private String idProofNumber;
    private LocalDateTime createdAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getIdProofNumber() {
        return idProofNumber;
    }
    public void setIdProofNumber(String idProofNumber) {
        this.idProofNumber = idProofNumber;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Visitor(Long id, String name, String email, String phonenumber, String idProofNumber, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.idProofNumber = idProofNumber;
        this.createdAt = createdAt;
    }
    public Visitor() {
    }
    
    
  
}