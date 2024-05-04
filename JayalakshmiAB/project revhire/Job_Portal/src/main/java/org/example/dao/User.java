package org.example.dao;

import org.example.model.EmployerModel;
import org.example.model.JobModel;


public interface User {
    void JobSeekerRegister(JobModel jobModel) ;
    void JobSeekerLogin();

    void getJobs();
    void applyForJob();
    void myApplication();
    void EmployerRegister(EmployerModel employerModel);
    void EmployerLogin();
    void postJob();
    void deleteJob();
    void viewApplications();
    void validateJobSeekerLogin();
    void validateEmployerLogin();
}
