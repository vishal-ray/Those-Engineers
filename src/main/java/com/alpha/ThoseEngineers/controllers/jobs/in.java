package com.alpha.ThoseEngineers.controllers.jobs;

import com.alpha.ThoseEngineers.modules.jobs.technicals.Domain;
import com.alpha.ThoseEngineers.repositories.jobs.technicals.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class in {
    @Autowired
    public DomainRepository domainRepository;

    @PostMapping("/domain")
    public Domain input(@RequestBody Domain domain)
    {
        domainRepository.save(domain);
        return domain;
    }
}
