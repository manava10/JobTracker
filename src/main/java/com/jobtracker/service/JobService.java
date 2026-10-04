package com.jobtracker.service;

import com.jobtracker.dto.JobDTO;
import com.jobtracker.entity.Job;
import java.util.*;
import com.jobtracker.repository.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ModelMapper modelMapper;
    public JobDTO saveAJob(JobDTO j){
        Job job = modelMapper.map(j,Job.class);
        Job returnJob = jobRepository.save(job);
        return modelMapper.map(returnJob,JobDTO.class);

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
    public JobDTO updateJobById(Long id, JobDTO jobDTO){
        Job job = jobRepository.findById(id).orElse(null);
        if(job==null){
            return null;
        }
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setLocation(jobDTO.getLocation());
        job.setJobType(jobDTO.getJobType());
        job.setSalary(jobDTO.getSalary());
        job.setExperienceReq(jobDTO.getExperienceReq());
        job.setPostedDate(jobDTO.getPostedDate());

        Job updatedJob = jobRepository.save(job);
        return  modelMapper.map(updatedJob, JobDTO.class);
    }
}
