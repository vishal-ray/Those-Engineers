package com.alpha.ThoseEngineers.repositories.jobs.technicals;

import com.alpha.ThoseEngineers.modules.jobs.technicals.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {
    @Query(value = "SELECT id FROM domains where domain_name =:DomainName",nativeQuery = true)
    public int getDomainId(String DomainName);
}