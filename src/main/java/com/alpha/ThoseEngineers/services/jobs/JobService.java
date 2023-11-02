package com.alpha.ThoseEngineers.services.jobs;

import com.alpha.ThoseEngineers.dto.jobs.CreateJobRequestBody;
import com.alpha.ThoseEngineers.dto.jobs.JobResponseBody;
import com.alpha.ThoseEngineers.modules.jobs.data.File;
import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import com.alpha.ThoseEngineers.modules.jobs.data.StatusList;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Domain;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Framework;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Language;
import com.alpha.ThoseEngineers.modules.users.User;
import com.alpha.ThoseEngineers.repositories.jobs.data.FileRepository;
import com.alpha.ThoseEngineers.repositories.jobs.data.JobRepository;
import com.alpha.ThoseEngineers.repositories.jobs.technicals.DomainRepository;
import com.alpha.ThoseEngineers.repositories.jobs.technicals.FrameworkRepository;
import com.alpha.ThoseEngineers.repositories.jobs.technicals.LanguageRepository;
import com.alpha.ThoseEngineers.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class JobService implements IJobService{

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public DomainRepository domainRepository;
    @Autowired
    public FileRepository fileRepository;
    @Autowired
    public JobRepository jobRepository;
    @Autowired
    public FrameworkRepository frameworkRepository;
    @Autowired
    public LanguageRepository languageRepository;

    public JobResponseBody create(CreateJobRequestBody jobRequestBody) {
        Job newJob = new Job();
        com.alpha.ThoseEngineers.dto.jobs.JobResponseBody responseBody = new com.alpha.ThoseEngineers.dto.jobs.JobResponseBody();

        newJob.setTitle(jobRequestBody.getTitle());
        newJob.setDescription(jobRequestBody.getDescription());
        newJob.setBudget(jobRequestBody.getBudget());
        newJob.setStatus(StatusList.OpenToBid);

        Domain domain = new Domain();
        domain.setId(domainRepository.getDomainId(jobRequestBody.getDomain()));

        Framework framework = new Framework();
        framework.setId(frameworkRepository.getFrameworkId(jobRequestBody.getFramework()));

        Language language = new Language();
        language.setId(languageRepository.getLanguageId(jobRequestBody.getLanguage()));

        User user = new User();
        user.setId((userRepository.getUserId(jobRequestBody.getUserRequestBody().getName(), jobRequestBody.getUserRequestBody().getMobNo(), jobRequestBody.getUserRequestBody().getEmailId())));

        File fileWithLink = new File();
        fileWithLink.setFileLink(jobRequestBody.getFileLink());
        fileRepository.save(fileWithLink);

        File newFile = new File();
        newFile.setId(fileRepository.getFileId(jobRequestBody.getFileLink()));

        newJob.setDomain(domain);
        newJob.setFramework(framework);
        newJob.setLanguage(language);
        newJob.setFile(newFile);
        newJob.setUser(user);

        jobRepository.saveAndFlush(newJob);

        responseBody.setTitle(jobRequestBody.getTitle());
        responseBody.setDescription(jobRequestBody.getDescription());
        responseBody.setBudget(jobRequestBody.getBudget());
        responseBody.setStatus(StatusList.OpenToBid);
        responseBody.setDomain(domain);
        responseBody.setFramework(framework);
        responseBody.setLanguage(language);
        responseBody.setFile(newFile);
        responseBody.setUser(user);

        return responseBody;
    }
    public List<JobResponseBody> read()
    {
        List<Job> jobList = jobRepository.getAllJobs();
        List<JobResponseBody> jobListResponse = new ArrayList<>();
        for(Job job : jobList) {
            JobResponseBody jobRes = new JobResponseBody();
            jobRes.setId(job.getId());
            jobRes.setTitle(job.getTitle());

            Framework framework = job.getFramework();
            framework.setJobList(null);
            jobRes.setFramework(framework);

            jobRes.setStatus(job.getStatus());
            jobRes.setDescription(job.getDescription());
            jobRes.setBudget(job.getBudget());

            jobRes.setCreatedAt(job.getCreatedAt());
            jobRes.setUpdatedAt(job.getUpdatedAt());
            
            User user = job.getUser();
            user.setJobList(null);
            jobRes.setUser(user);

            Domain domain = job.getDomain();
            domain.setJobList(null);
            jobRes.setDomain(domain);

            Language language = job.getLanguage();
            language.setJobList(null);
            jobRes.setLanguage(language);

            File file = job.getFile();
            file.setJob(null);
            jobRes.setFile(file);



            jobListResponse.add(jobRes);
        }
        return jobListResponse;
    }

    public JobResponseBody readById(Long id)
    {
        Job job = jobRepository.getReferenceById(id);
        JobResponseBody jobRes = new JobResponseBody();
        jobRes.setId(job.getId());
        jobRes.setTitle(job.getTitle());

        Framework framework = job.getFramework();
        framework.setJobList(null);
        jobRes.setFramework(framework);

        jobRes.setStatus(job.getStatus());
        jobRes.setDescription(job.getDescription());
        jobRes.setBudget(job.getBudget());

        User user = job.getUser();
        user.setJobList(null);
        jobRes.setUser(user);

        Domain domain = job.getDomain();
        domain.setJobList(null);
        jobRes.setDomain(domain);

        Language language = job.getLanguage();
        language.setJobList(null);
        jobRes.setLanguage(language);

        jobRes.setCreatedAt(job.getCreatedAt());
        jobRes.setUpdatedAt(job.getUpdatedAt());

        File file = job.getFile();
        file.setJob(null);
        jobRes.setFile(file);


        return jobRes;
    }

    @Transactional
    public String delete(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        if(job.isEmpty())
            return "Job Not Present";
        jobRepository.delete(job.get());
        return "Job Successfully Deleted";
    }

    public String update(Job updatedJob)
    {
        Optional<Job> oldJob = jobRepository.findById((long) updatedJob.getId());
        if(oldJob.isEmpty())
            return "Job Not Found";
        oldJob.ifPresent(job -> {
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setBudget(updatedJob.getBudget());
            job.setStatus(updatedJob.getStatus());
            job.setLanguage(updatedJob.getLanguage());
            job.setDomain(updatedJob.getDomain());
            job.setFramework(updatedJob.getFramework());
            jobRepository.save(job);
        });
        return "Job Successfully Updated";
    }

}
