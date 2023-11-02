package com.alpha.ThoseEngineers.modules.jobs.technicals;

import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "domains")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "domain_name")
    @Enumerated(EnumType.STRING)
    private DomainName domainName;

//
//    //  Domain ---> Framework Linkage
//    @OneToMany(mappedBy = "domain",cascade = CascadeType.ALL)
//    private List<Framework> frameworkList;
//
//    // Domain ---> Language Linkage
//    @OneToMany(mappedBy = "domain",cascade = CascadeType.ALL)
//    private List<Language> languageList;

    // Domain ---> Job Linkage
    @OneToMany(mappedBy = "domain",cascade = CascadeType.ALL)
    private List<Job> jobList;



    // Getters, Setters and Constructors

    public Domain() {
    }

    public Domain(Integer id, DomainName domainName,  List<Language> languageList, List<Job> jobList) {
        this.id = id;
        this.domainName = domainName;
//        this.frameworkList = frameworkList;
//        this.languageList = languageList;
        this.jobList = jobList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DomainName getDomainName() {
        return domainName;
    }

    public void setDomainName(DomainName domainName) {
        this.domainName = domainName;
    }

//    public List<Framework> getFrameworkList() {
//        return frameworkList;
//    }
//
//    public void setFrameworkList(List<Framework> frameworkList) {
//        this.frameworkList = frameworkList;
//    }
//
//    public List<Language> getLanguageList() {
//        return languageList;
//    }
//
//    public void setLanguageList(List<Language> languageList) {
//        this.languageList = languageList;
//    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
}
