package com.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recruiter")
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Long phoneNumber;
}
