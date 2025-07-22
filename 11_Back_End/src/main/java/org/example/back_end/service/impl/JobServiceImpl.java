//package org.example.back_end.service.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.example.back_end.dto.JobDTO;
//import org.example.back_end.entity.Job;
//import org.example.back_end.repository.JobRepository;
//import org.example.back_end.service.JobService;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class JobServiceImpl implements JobService {
//    private final JobRepository jobRepository;
//    private final ModelMapper modelMapper;
//
//    @Override
//    public void saveJob(JobDTO jobDTO) {
//        jobRepository.save(modelMapper.map(jobDTO, Job.class));
//
//    }
//
//    @Override
//    public void updateJob(JobDTO jobDTO) {
//        jobRepository.save(modelMapper.map(jobDTO, Job.class));
//    }
//
//    @Override
//    public List<JobDTO> getAllJobs() {
//        List<Job> jobs = jobRepository.findAll();
//        return jobs.stream()
//                .map(job -> modelMapper.map(job, JobDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void changeJobStatus(String id) {
//        jobRepository.updateJobStatus(id);
//    }
//
//    @Override
//    public List<JobDTO> getAllJobsByKeyword(String keyword) {
//        List<Job> list = jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
//        return modelMapper.map(list,new TypeToken<List<JobDTO>>(){}.getType());
//
//    }
//
//    @Override
//    public JobDTO getJobById(int id) {
//        Job job = jobRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + id));
//        return modelMapper.map(job,JobDTO.class);
//    }
//
//    @Override
//    public void deleteJob(int id) {
//        jobRepository.deleteById(id);
//    }
//
//    public Page<JobDTO> getJobs(Pageable pageable) {
//        return jobRepository.findAll(pageable).map(jobEntity -> convertToDto(jobEntity));
//    }
//
//    private JobDTO convertToDto(Job jobEntity) {
//    }
//}

package org.example.back_end.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.entity.Job;
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
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public void updateJob(JobDTO jobDTO) {
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(job -> modelMapper.map(job, JobDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void changeJobStatus(String id) {
        jobRepository.updateJobStatus(id);
    }

    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
        List<Job> list = jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
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
        jobRepository.deleteById(id);
    }

    // Pagination support method
    @Override
    public Page<JobDTO> getJobs(Pageable pageable) {
        // Fetch paginated Job entities from repository
        Page<Job> jobsPage = jobRepository.findAll(pageable);

        // Convert Job entities Page<Job> to Page<JobDTO>
        return jobsPage.map(this::convertToDto);
    }

    // Convert Job entity to JobDTO
    private JobDTO convertToDto(Job jobEntity) {
        return modelMapper.map(jobEntity, JobDTO.class);
    }
}

