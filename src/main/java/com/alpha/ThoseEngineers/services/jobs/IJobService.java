package com.alpha.ThoseEngineers.services.jobs;

import com.alpha.ThoseEngineers.dto.jobs.CreateJobRequestBody;
import com.alpha.ThoseEngineers.dto.jobs.JobResponseBody;
import com.alpha.ThoseEngineers.modules.jobs.data.Job;

import java.util.List;

public interface IJobService {
    public JobResponseBody create(CreateJobRequestBody jobRequestBody);
    public List<JobResponseBody> read();
    public String delete(Long id);
    public String update(Job jobRequestBody);

    public JobResponseBody readById(Long id);
}
