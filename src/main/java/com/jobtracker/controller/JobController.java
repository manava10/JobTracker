package com.jobtracker.controller;
import com.jobtracker.dto.JobDTO;
import com.jobtracker.entity.Job;
import com.jobtracker.service.JobService;
import jakarta.servlet.ServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobtracker")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/jobs")
    public ResponseEntity<JobDTO> postJob(@RequestBody  JobDTO b){
        JobDTO j = jobService.saveAJob(b);
        return new ResponseEntity<>(j, HttpStatus.CREATED);
    }
    @GetMapping("/jobs")
    public ResponseEntity<List<JobDTO>> getAllJobs(){
        List<JobDTO> jobList = jobService.getAllJobs();
        return new ResponseEntity<>(jobList,HttpStatus.OK);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable  Long id){
        JobDTO job = jobService.getJobById(id);
        return new ResponseEntity<>(job,HttpStatus.OK);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long id, @RequestBody JobDTO job, ServletRequest servletRequest){
        JobDTO jobDTO = jobService.updateJobById(id,job);
        return new ResponseEntity<>(jobDTO,HttpStatus.CREATED);
    }
}