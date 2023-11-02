package com.alpha.ThoseEngineers.modules.users;

import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

enum Usertype{
    Freelancer,Employer;
}

@Entity
@Table(name = "users")
public class User {

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "mob_no",unique = true)
    private Long mobNo;

    @Column(name = "email_id",unique = true)
    private String emailId;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private Usertype usertype;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Job> jobList;


    // Getters, Setters and Constructors
    public User() {
    }

    public User(Integer id, String name, Long mobNo, String emailIid, Usertype usertype, LocalDateTime createdAt, LocalDateTime updatedAt, List<Job> jobList) {
        this.id = id;
        this.name = name;
        this.mobNo = mobNo;
        this.emailId = emailIid;
        this.usertype = usertype;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.jobList = jobList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobNo() {
        return mobNo;
    }

    public void setMobNo(Long mobNo) {
        this.mobNo = mobNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Usertype getUsertype() {
        return usertype;
    }

    public void setUsertype(Usertype usertype) {
        this.usertype = usertype;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    @JsonIgnore
    public List<Job> getJobList() {
        return jobList;
    }
    @JsonIgnore
    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
}
