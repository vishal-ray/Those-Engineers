package com.alpha.ThoseEngineers.dto.jobs;

enum StatusList{
    OpenToBid,
    Assigned,
    InProgress,
    Completed,
    Inactive
}
public class CreateJobRequestBody {

    private String title;
    private String description;
    private Long budget;
    private String domain;
    private String framework;
    private String language;
    private String fileLink;

    private UserRequestBody userRequestBody;


    public CreateJobRequestBody() {
    }

    public CreateJobRequestBody(String title, String description, Long budget, String domain, String framework, String language, String fileLink, UserRequestBody userRequestBody) {
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.domain = domain;
        this.framework = framework;
        this.language = language;
        this.fileLink = fileLink;
        this.userRequestBody = userRequestBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public UserRequestBody getUserRequestBody() {
        return userRequestBody;
    }

    public void setUserRequestBody(UserRequestBody userRequestBody) {
        this.userRequestBody = userRequestBody;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
}
