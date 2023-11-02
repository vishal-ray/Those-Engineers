package com.alpha.ThoseEngineers.dto.jobs;

public class UserRequestBody {
    private String name;
    private Long mobNo;
    private String emailId;

    public UserRequestBody() {
    }

    public UserRequestBody(String name, Long mobNo, String emailId) {
        this.name = name;
        this.mobNo = mobNo;
        this.emailId = emailId;
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
}
