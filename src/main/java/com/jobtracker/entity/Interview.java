package com.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "interview")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate interviewDate;
    @Enumerated(EnumType.STRING)
    private InterviewType interviewType;
    private String result;
    private String feedback;
}
