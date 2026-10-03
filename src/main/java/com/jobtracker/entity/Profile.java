package com.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long phoneNumber;
    private String location;
    private String[] skills;
    private String resumeUrl;
}
