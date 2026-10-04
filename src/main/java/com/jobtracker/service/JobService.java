package com.jobtracker.service;

import com.jobtracker.dto.JobDTO;
import com.jobtracker.entity.Job;
import java.util.*;
import com.jobtracker.repository.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ModelMapper modelMapper;
    public JobDTO saveAJob(JobDTO j){
        jobRepository.save(modelMapper.map(j,Job.class));
        return j;
    }
    //Method to get all Jobs
    public List<JobDTO> getAllJobs() {
        List<Job> jobList = jobRepository.findAll();
        List<JobDTO> jobDTOList = new ArrayList<>();
        jobDTOList = jobList.stream().map((Job a )->{
            return modelMapper.map(a,JobDTO.class);
        }).toList();
        return jobDTOList;
    }
    
    //Get Job By Id;
    public JobDTO getJobById(Long id){
        Job job =  jobRepository.findById(id)
                .orElse(null);
        if(job!=null){
            return modelMapper.map(job,JobDTO.class);
        }
        return null;
    }
}
