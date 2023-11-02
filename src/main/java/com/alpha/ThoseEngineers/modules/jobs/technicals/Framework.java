package com.alpha.ThoseEngineers.modules.jobs.technicals;

import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "frameworks")
public class Framework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "framework_name")
    @Enumerated(EnumType.STRING)
    private FrameworkName frameworkName;

//    @ManyToOne()
//    @JoinColumn(name = "domain_id")
//    private Domain domain;

    @OneToMany(mappedBy = "framework",cascade = CascadeType.ALL)
    private List<Job> jobList;


    public Framework() {
    }

    public Framework(Integer id, FrameworkName frameworkName, Domain domain, List<Job> jobList) {
        this.id = id;
        this.frameworkName = frameworkName;
//        this.domain = domain;
        this.jobList = jobList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FrameworkName getFrameworkName() {
        return frameworkName;
    }

    public void setFrameworkName(FrameworkName frameworkName) {
        this.frameworkName = frameworkName;
    }

//    public Domain getDomain() {
//        return domain;
//    }
//
//    public void setDomain(Domain domain) {
//        this.domain = domain;
//    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
}
