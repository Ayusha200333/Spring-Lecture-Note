package org.example.back_end.service;

import org.example.back_end.dto.JobDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobService {
    public void saveJob(JobDTO jobDTO);
    public void updateJob(JobDTO jobDTO);

    List<JobDTO> getAllJobs();

    void changeJobStatus(String id);

    List<JobDTO> getAllJobsByKeyword(String keyword);

    JobDTO getJobById(int id);

    void deleteJob(int id);

    // Pagination support method
    Page<JobDTO> getJobs(Pageable pageable);
}
