package com.alpha.ThoseEngineers.repositories.jobs.data;

import com.alpha.ThoseEngineers.modules.jobs.data.File;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    @Query(value = "SELECT id FROM files where file_link =:FileLink LIMIT 1",nativeQuery = true)
    public int getFileId(String FileLink);
}