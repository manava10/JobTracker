package com.jobtracker.controller;
import com.jobtracker.entity.Job;
import com.jobtracker.service.JobService;
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
    @PostMapping("/jobs")
    public ResponseEntity<Job> postJob(@RequestBody  Job b){
        jobService.saveAJob(b);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    @GetMapping("jobs")
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobList = jobService.getAllJobs();
        return new ResponseEntity<>(jobList,HttpStatus.OK);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable  Long id){
        Job job = jobService.getJobById(id);
        return new ResponseEntity<>(job,HttpStatus.OK);
    }
}