package org.example.back_end.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.back_end.dto.JobDTO;
import org.example.back_end.service.impl.JobServiceImpl;
import org.example.back_end.utill.APIResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/job")
@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class JobController {
    private final JobServiceImpl jobService;

    @PostMapping("create")
    public ResponseEntity<APIResponse> createJob(@Valid @RequestBody JobDTO jobDTO) {
        log.info("INFO- Job created: ");
        log.debug("DEBUG- Job created: ");
        log.warn("WARN- Job created: ");
        log.trace("TRACE- Job created: ");
        log.error("ERROR- Job created: ");
        jobService.saveJob(jobDTO);
        return ResponseEntity.ok(new APIResponse(
                201,
                "Job created Successfully",
                null
                ));
    }

    @PutMapping("update")
    public ResponseEntity <APIResponse> updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return ResponseEntity.ok(new APIResponse(
                200,
                "updated successfully",
                null
        ));
    }

    @GetMapping("all")
    public ResponseEntity<APIResponse> getAllJobs() {
        List<JobDTO> jobDTOS = jobService.getAllJobs();
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "Job Status Changed Successfully",
                        jobDTOS
                )
        );
    }

    @PatchMapping("status/{id}")
//    public void changeStatus(@PathVariable("id") String id) {
//        jobService.changeJobStatus(id);
    private ResponseEntity<APIResponse>changeJobStatus(@PathVariable("id") String id) {
        jobService.changeJobStatus(id);
        return ResponseEntity.ok(new APIResponse(
                200,
                "status changed success",
                null
        ));
    }


    @GetMapping("search/{keyword}")
    public ResponseEntity<APIResponse> searchJob(@PathVariable("keyword") String keyword) {
        List<JobDTO> jobDTOS = jobService.getAllJobsByKeyword(keyword);
       return ResponseEntity.ok(new APIResponse(
               200,
               "Fetched success",
               jobDTOS
       ));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<APIResponse> getJobById(@PathVariable("id") int id) {
        JobDTO jobDTO = jobService.getJobById(id);
        return ResponseEntity.ok(new APIResponse(
                200,
                "Job retrieved successfully",
                jobDTO
        ));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<APIResponse> deleteJob(@PathVariable("id") int id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok(new APIResponse(
                200,
                "Job deleted successfully",
                null
        ));
    }

    @GetMapping("jobs")
    public ResponseEntity<APIResponse> getJobs(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<JobDTO> jobsPage = jobService.getJobs(pageable);
        return ResponseEntity.ok(new APIResponse(
                200,
                "Paged jobs retrieved successfully",
                jobsPage
        ));
    }

}

