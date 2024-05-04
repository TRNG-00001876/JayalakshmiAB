package org.example.service;

import org.example.dao.User;
import org.example.model.EmployerModel;
import org.example.model.JobOpeningModel;
import org.example.model.JobModel;

import java.util.List;

public class JobSeekerService {

    private User jobSeeker;

    public JobSeekerService(User userDAO) {
        this.jobSeeker = userDAO;
    }

    public void JobSeekerRegister(JobModel jobModel) {
     jobSeeker.JobSeekerRegister(jobModel);
    }

    public void validateJobSeekerLogin(){
    jobSeeker.validateJobSeekerLogin();
    }
}
