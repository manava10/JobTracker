package com.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "job")
public class Job
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    @Enumerated(EnumType.STRING)
    private JobType jobType;
    private Integer salary;
    private Integer experienceReq;
    private LocalDate postedDate;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "job")
    private List<Application> applications;
}
