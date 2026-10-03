package com.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "job")
public class Job
{
    @Id
    private Long id;
    private String title;
    private String description;
    private String location;
    @Enumerated(EnumType.STRING)
    private Integer salary;
    private Integer experienceReq;
    private LocalDate postedDate;
}
