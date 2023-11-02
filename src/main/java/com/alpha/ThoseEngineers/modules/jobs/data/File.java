package com.alpha.ThoseEngineers.modules.jobs.data;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "file_link")
    private String fileLink;

    @OneToOne(mappedBy = "file")
    private Job job;

    public File() {
    }

    public File(Integer id, String fileLink, Job job) {
        this.id = id;
        this.fileLink = fileLink;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
