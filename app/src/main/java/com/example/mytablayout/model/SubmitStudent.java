package com.example.mytablayout.model;

import com.google.gson.annotations.SerializedName;

public class SubmitStudent {

        @SerializedName("entry.1877115667")
        private String studentName;

        @SerializedName("entry.2006916086")
        private String studentLastName;

        @SerializedName("entry.1824927963")
        private String emailAddress;

        @SerializedName("entry.284483984")
        private String projectLink;


    public SubmitStudent(String studentName, String studentLastName, String emailAddress, String projectLink) {
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.emailAddress = emailAddress;
        this.projectLink = projectLink;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
}
