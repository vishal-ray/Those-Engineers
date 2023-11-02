package com.alpha.ThoseEngineers.controllers.jobs;

import com.alpha.ThoseEngineers.dto.jobs.CreateJobRequestBody;
import com.alpha.ThoseEngineers.dto.jobs.JobResponseBody;
import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import com.alpha.ThoseEngineers.services.jobs.IJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class JobController {
    @Autowired
    public IJobService jobPostService;
    private static final Logger log = LoggerFactory.getLogger(JobController.class);
    @PostMapping(value = "/jobs")
    public JobResponseBody create(@RequestBody CreateJobRequestBody jobRequestBody)
    {
        log.info("Inside PostJob Method");
        return jobPostService.create(jobRequestBody);
    }
    @GetMapping("/jobs")
    public List<JobResponseBody> read()
    {
        return jobPostService.read();
    }
    @GetMapping("/jobs/{id}")
    public JobResponseBody readById(@PathVariable Long id)
    {
        return jobPostService.readById(id);
    }
    @DeleteMapping("/jobs/{id}")
    public String delete(@PathVariable Long id)
    {
        return jobPostService.delete(id);
    }
    @PutMapping("/jobs")
    public String update(@RequestBody Job updatedJob)
    {
        return jobPostService.update(updatedJob);
    }
}
