package com.alpha.ThoseEngineers.repositories.jobs.data;

import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query(value = "SELECT * FROM jobs",nativeQuery = true)
    public List<Job> getAllJobs();
}