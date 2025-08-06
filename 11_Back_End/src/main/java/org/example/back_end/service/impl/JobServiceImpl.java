package org.example.back_end.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.entity.Job;
import org.example.back_end.exceptions.ResourceAlreadyFoundException;
import org.example.back_end.exceptions.ResourceNotFoundExceptions;
import org.example.back_end.repository.JobRepository;
import org.example.back_end.service.JobService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveJob(JobDTO jobDTO) {
        if (jobRepository.existsById(jobDTO.getId())) {
            throw new ResourceAlreadyFoundException(" already exists");
        }
        // jobRepository.save(modelMapper.map(jobDTO, Job.class));
        throw new ResourceAlreadyFoundException(" already exists");

    }

    @Override
    public void updateJob(JobDTO jobDTO) {
        if (jobDTO == null || jobDTO.getId() == null) {
            throw new ResourceAlreadyFoundException("JobDTO and ID cannot be null");
        }

        boolean exists = jobRepository.existsById(jobDTO.getId());
        if (!exists) {
            throw new ResourceAlreadyFoundException("Cannot update. Job not found with ID: " + jobDTO.getId());
        }

        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        if (jobs.isEmpty()) {
            throw new ResourceNotFoundExceptions("No jobs found");
        }
        return jobs.stream()
                .map(job -> modelMapper.map(job, JobDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void changeJobStatus(String id) {
        if (id == null || id.isBlank()) {
            throw new ResourceAlreadyFoundException("Job ID cannot be null or blank");
        }

        boolean exists = jobRepository.existsById(Integer.parseInt(id));
        if (!exists) {
            throw new ResourceAlreadyFoundException("Job not found with ID: " + id);
        }

        jobRepository.updateJobStatus(id);
    }

    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
        List<Job> list = jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
        if (list.isEmpty()) {
            throw new ResourceNotFoundExceptions("No jobs found matching keyword: " + keyword);
        }
        return modelMapper.map(list, new TypeToken<List<JobDTO>>() {}.getType());
    }

    @Override
    public JobDTO getJobById(int id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + id));
        return modelMapper.map(job, JobDTO.class);
    }

    @Override
    public void deleteJob(int id) {
        boolean exists = jobRepository.existsById(id);
        if (!exists) {
            throw new ResourceNotFoundExceptions("Cannot delete. Job not found with ID: " + id);
        }
        jobRepository.deleteById(id);
    }


    @Override
    public Page<JobDTO> getJobs(Pageable pageable) {
        Page<Job> jobsPage = jobRepository.findAll(pageable);

        if (jobsPage.isEmpty()) {
            throw new ResourceNotFoundExceptions("No jobs found for the requested page.");
        }

        return jobsPage.map(this::convertToDto);
    }

    // Convert Job entity to JobDTO
    private JobDTO convertToDto(Job jobEntity) {
        return modelMapper.map(jobEntity, JobDTO.class);
    }
}

