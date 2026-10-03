package com.jobtracker.service;

import com.jobtracker.entity.Job;
import java.util.*;
import com.jobtracker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    public Job saveAJob(Job j){
        jobRepository.save(j);
        return j;
    }
    
    //Method to get all Jobs
    public List<Job> getAllJobs() {
        List<Job> jobList = jobRepository.findAll();
        return jobList;
    }
    
    //Get Job By Id;
    public Job getJobById(Long id){
        Optional<Job> job = jobRepository.findById(id);
        Job job1 = job.get();
        return job1;
    }
}
