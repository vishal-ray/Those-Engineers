package com.alpha.ThoseEngineers.repositories.jobs.technicals;

import com.alpha.ThoseEngineers.modules.jobs.technicals.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrameworkRepository extends JpaRepository<Framework, Long> {
    @Query(value = "SELECT id FROM frameworks where framework_name =:FrameworkName",nativeQuery = true)
    public int getFrameworkId(String FrameworkName);
}