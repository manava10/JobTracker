package com.jobtracker.dto;
import com.jobtracker.entity.JobType;
import lombok.Data;

import java.time.LocalDate;

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
