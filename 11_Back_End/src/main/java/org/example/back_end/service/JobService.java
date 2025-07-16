package org.example.back_end.service;

import org.example.back_end.dto.JobDTO;

import java.util.List;

public interface JobService {
    public void saveJob(JobDTO jobDTO);
    public void updateJob(JobDTO jobDTO);

    List<JobDTO> getAllJobs();

    void changeJobStatus(String id);

    List<JobDTO> getAllJobsByKeyword(String keyword);
}
