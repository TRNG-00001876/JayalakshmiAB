package org.example.service;

import org.example.Dao.UserDao;
import org.example.model.Employeereg;
import org.example.model.UserReg;
import org.example.model.Resume;
import org.example.model.JobListing;

import java.util.List;

public class Service {
    private UserDao userDao;

    public Service(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUserDetails(UserReg userreg) {
        userDao.addUserDetails(userreg);
    }

    public void addEmployeeDetails(Employeereg employeereg) {
        userDao.addEmployeeDetails(employeereg);
    }

    public boolean validateUser(String username, String userpassword) {
        return userDao.validateUser(username, userpassword);
    }

    public boolean validateEmployee(String email, String emp_key) {
        return userDao.validateEmployee(email, emp_key);
    }


    public boolean validatePhoneNumber(String username, int phoneNumber, String newPassword) {
        if (userDao.validatePhoneNumber(username, phoneNumber, newPassword)) {
            return true;
        } else {
            return false;
        }
    }
    public void addResume(String username,String password,Resume resume) {
        userDao.addResume(username,password,resume);
    }

//    public List<Resume> getAllResumes() {
//        return userDao.getAllResumes();
//    }
//
//    public void updateResume(Resume resume) {
//        userDao.updateResume(resume);
//    }

//    public void deleteResume(int resumeID) {
//        userDao.deleteResume(resumeID);
//    }
    public void addJobListing(JobListing jobListing) {
        userDao.addJobListing(jobListing);
    }

    public List<JobListing> getAllJobListings() {
        return userDao.getAllJobListings();
    }

    public void updateJobListing(JobListing jobListing) {
        userDao.updateJobListing(jobListing);
    }

    public void deleteJobListing(int jobID) {
        userDao.deleteJobListing(jobID);
    }
}







