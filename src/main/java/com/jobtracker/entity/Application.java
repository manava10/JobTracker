package com.jobtracker.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.TypeAlias;

import java.time.LocalDate;

@Entity
@Table(name="application")
public class Application
{
    @Id
    private Long id;
    private LocalDate appliedDate;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private String coverLetter;
}
