package org.example.Dao;
import org.example.model.Employeereg;
import org.example.model.UserReg;
import org.example.model.Resume;
import org.example.model.JobListing;
import java.util.List;

public interface UserDao {
    void addUserDetails(UserReg userreg);

    void addEmployeeDetails(Employeereg employeereg);

    boolean validateUser(String username, String userpassword); // Validation method for user login

    boolean validateEmployee(String email, String emp_key);

    boolean validatePhoneNumber(String username, int phoneNumber, String newpassword);
    void addResume(String username,String password ,Resume resume);

//    List<Resume> getAllResumes();
//
//    void updateResume(Resume resume);
//
//    void deleteResume(int resumeID);

    void addJobListing(JobListing jobListing);

    List<JobListing> getAllJobListings();

    void updateJobListing(JobListing jobListing);

    void deleteJobListing(int jobID);


}

