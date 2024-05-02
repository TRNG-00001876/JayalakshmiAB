package org.example.Dao;
import org.example.model.Employeereg;
import org.example.model.UserReg;
import org.example.model.Resume;
import org.example.model.JobListing;

import java.sql.*;
import java.util.List;

//import java.sql.ResultSet;
import java.util.ArrayList;


//import java.util.ArrayList;
public class Daoimplementation implements UserDao {
    private static UserDao instance;
    private Connection connection;

    // Private constructor to prevent external instantiation
    private Daoimplementation(Connection connection) {
        this.connection = connection;
    }

    // Method to get the singleton instance
    public static synchronized Daoimplementation getInstance(Connection connection) {
        if (instance == null) {
            instance = new Daoimplementation(connection);
        }
        return (Daoimplementation) instance;
    }

    public void addUserDetails(UserReg userreg) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username,useremail,userpassword,user_phoneno) VALUES (?, ?, ?,?)");
            preparedStatement.setString(1, userreg.getUsername());
            preparedStatement.setString(2, userreg.getUseremail());
            preparedStatement.setString(3, userreg.getUserpassword());
            preparedStatement.setLong(4, userreg.getUser_phoneno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void addEmployeeDetails(Employeereg employeereg) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employee (emp_id,firstname,lastname,position,department,salary,emp_key) VALUES (?,?, ?, ?,?,?,?)");
            preparedStatement.setString(1, employeereg.getCompany());
            preparedStatement.setString(2, employeereg.getUsername());
            preparedStatement.setString(3, employeereg.getEmail());
            preparedStatement.setString(4, employeereg.getEmp_key());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean validateUser(String username, String userpassword) {
        String sql = "SELECT * FROM users WHERE username = ? AND userpassword = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, userpassword);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validateEmployee(String email, String emp_key) {
        String sql = "SELECT * FROM Employee WHERE Email = ? AND emp_key = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, emp_key);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validatePhoneNumber(String username, int phoneNumber, String newpassword) {
        String sql = "SELECT * FROM users WHERE username = ? AND user_phone_number = ? AND newpassword";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, String.valueOf(phoneNumber));
            preparedStatement.setString(3, newpassword);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addResume(String username,String password,Resume resume) {
        String sql="Select userid from users where username =? AND userpassword=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int userid = rs.getInt("userid");


                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Resumes VALUES (?, ?, ?, ?, ?, ?,?,?)");
                preparedStatement.setInt(1, userid);
                preparedStatement.setString(2, resume.getFirstname());
                preparedStatement.setString(3, resume.getLastname());
                preparedStatement.setString(4, resume.getDob());
                preparedStatement.setString(5, resume.getMail());
                preparedStatement.setLong(6, resume.getPhonenumber());
                preparedStatement.setString(7,resume.getHighereducation());
                preparedStatement.setInt(8, resume.getMarks());

                preparedStatement.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
////    public List<Resume> getAllResumes() {
////        List<Resume> resumes = new ArrayList<>();
////        try {
////            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Resumes");
////            ResultSet resultSet = preparedStatement.executeQuery();
////            while (resultSet.next()) {
////                int resumeID = resultSet.getInt("ResumeID");
////                String names = resultSet.getString("Names");
////                String email = resultSet.getString("Email");
////                int experienceYears = resultSet.getInt("ExperienceYears");
////                String skills = resultSet.getString("Skills");
////                String education = resultSet.getString("Education");
////
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return resumes;
////    }
////
////    @Override
////    public void updateResume(Resume resume) {
////        try {
////            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Resumes SET Names=?, Email=?, ExperienceYears=?, Skills=?, Education=? WHERE ResumeID=?");
////            preparedStatement.setString(1, resume.getNames());
////            preparedStatement.setString(2, resume.getEmailId());
////            preparedStatement.setInt(3, resume.getExperienceYears());
////            preparedStatement.setString(4, resume.getSkills());
//            preparedStatement.setString(5, resume.getEducation());
//            preparedStatement.setInt(6, resume.getResumeID());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void deleteResume(int resumeID) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Resumes WHERE ResumeID=?");
//            preparedStatement.setInt(1, resumeID);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//

    @Override
    public void addJobListing(JobListing jobListing) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO JobListings (JobID, JobTitle, Companyname, Loc, experience) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, jobListing.getJobID());
            preparedStatement.setString(2, jobListing.getJobTitle());
            preparedStatement.setString(3, jobListing.getCompanyname());
            preparedStatement.setString(4, jobListing.getLoc());
            preparedStatement.setInt(5, jobListing.getExperience());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<JobListing> getAllJobListings() {
        List<JobListing> jobListings = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JobListings");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int jobID = resultSet.getInt("JobID");
                String jobTitle = resultSet.getString("JobTitle");
                String companyName = resultSet.getString("Companyname");
                String loc = resultSet.getString("Loc");
                int experience = resultSet.getInt("experience");
                jobListings.add(new JobListing(jobID, jobTitle, companyName, loc, experience));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobListings;
    }

    @Override
    public void updateJobListing(JobListing jobListing) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE JobListings SET JobTitle=?, Companyname=?, Loc=?, experience=? WHERE JobID=?");
            preparedStatement.setString(1, jobListing.getJobTitle());
            preparedStatement.setString(2, jobListing.getCompanyname());
            preparedStatement.setString(3, jobListing.getLoc());
            preparedStatement.setInt(4, jobListing.getExperience());
            preparedStatement.setInt(5, jobListing.getJobID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteJobListing(int jobID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM JobListings WHERE JobID=?");
            preparedStatement.setInt(1, jobID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


