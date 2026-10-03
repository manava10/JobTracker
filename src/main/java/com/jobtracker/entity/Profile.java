package com.jobtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="profile")
public class Profile {
    @Id
    private Long id;
    private Long phoneNumber;
    private String Location;
    private String[] skills;
    private String resumeUrl;
}
