package com.jobtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recruiter")
public class Recruiter {
    @Id
    private Long id;
    private String name;
    private String email;
    private Long phoneNumber;
}
