package com.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
@Data
@Entity
@Table(name="application")
public class Application
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate appliedDate;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private String coverLetter;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job")
    private Job job;
}
