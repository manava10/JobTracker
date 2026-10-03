package com.jobtracker.DTO;

import com.jobtracker.entity.Application;
import com.jobtracker.entity.Company;
import com.jobtracker.entity.JobType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class JobDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    private JobType jobType;
    private Integer salary;
    private Integer experienceReq;
    private LocalDate postedDate;
}
