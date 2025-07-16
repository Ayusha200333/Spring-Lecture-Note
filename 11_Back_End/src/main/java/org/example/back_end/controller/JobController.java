package org.example.back_end.controller;


import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.service.impl.JobServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/job")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class JobController {
    private final JobServiceImpl jobService;

    @PostMapping("create")
    public void createJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
    }

    @PutMapping("update")
    public void updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
    }

    @GetMapping("all")
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PatchMapping("status/{id}")
    public void changeStatus(@PathVariable("id") String id) {
        jobService.changeJobStatus(id);
    }

    @GetMapping("search/{keyword}")
    public List<JobDTO> searchJob(@PathVariable("keyword") String keyword) {
        return jobService.getAllJobsByKeyword(keyword);
    }
}
