package com.jobtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    private Long id;
    private String name;
    private String industry;
    private String location;
    private String website;
    private LocalDateTime createdAt;
}
