package com.jobtracker.controller;
import com.jobtracker.dto.JobDTO;
import com.jobtracker.entity.Job;
import com.jobtracker.service.JobService;
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
        jobService.saveAJob(b);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }
    @GetMapping("/jobs")
    public ResponseEntity<List<JobDTO>> getAllJobs(){
        List<JobDTO> jobList = jobService.getAllJobs().stream().map(a->
                modelMapper.map(a,JobDTO.class)).toList();
        return new ResponseEntity<>(jobList,HttpStatus.OK);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable  Long id){
        JobDTO job =modelMapper.map(jobService.getJobById(id),JobDTO.class);
        return new ResponseEntity<>(job,HttpStatus.OK);
    }
}