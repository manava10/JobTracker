package com.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String industry;
    private String location;
    private String website;
    private LocalDateTime createdAt;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "company"
    )
    private List<Job> job;
}
