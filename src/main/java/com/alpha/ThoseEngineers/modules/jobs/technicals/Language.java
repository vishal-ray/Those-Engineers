package com.alpha.ThoseEngineers.modules.jobs.technicals;

import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "languages_name")
    @Enumerated(EnumType.STRING)
    private LanguageName languageName;

//    @ManyToOne()
//    @JoinColumn(name = "domain_id")
//    private Domain domain;


    @OneToMany(mappedBy = "language",cascade = CascadeType.ALL)
    private List<Job> jobList;

    public Language() {
    }

    public Language(Integer id, LanguageName languageName,  List<Job> jobList) {
        this.id = id;
        this.languageName = languageName;
//        this.domain = domain;
        this.jobList = jobList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LanguageName getLanguageName() {
        return languageName;
    }

    public void setLanguageName(LanguageName languageName) {
        this.languageName = languageName;
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
