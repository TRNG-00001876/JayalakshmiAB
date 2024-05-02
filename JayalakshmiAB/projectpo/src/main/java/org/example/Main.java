package org.example;

import org.example.Dao.UserDao;
import org.example.Dao.Daoimplementation;
import org.example.model.Employeereg;
import org.example.model.UserReg;
import org.example.service.Service;
import org.example.model.Resume;
import org.example.model.JobListing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {

   static  String username ="";
   static String password = "";
    static {
        System.out.println("ReVhIRE'S WEBSITE");
        System.out.println();
    }

    public static void main(String[] args) {




        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Rev_console;integratedSecurity=True;encrypt=True;TrustServerCertificate=True");
            UserDao userDao = Daoimplementation.getInstance(con);
            Service service = new Service(userDao);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("JOB PORTAL");
                System.out.println("1. JOBSEEKER");
                System.out.println("2. EMPLOYEE");
                System.out.println("3. EXIT");
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        jobSeekerOperations(service, scanner);
                        break;
                    case 2:
                        employeeOperations(service, scanner);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void jobSeekerOperations(Service service, Scanner scanner) {
        boolean exit1 = true;
        while (exit1) {
            System.out.println("Choose operation:");
            System.out.println("1. REGISTER");
            System.out.println("2. LOG IN");
            System.out.println("3. Back to main menu");
            System.out.println("4.Forgot password");
            System.out.println("5.Resume");
            int choice_out = scanner.nextInt();
            switch (choice_out) {
                case 1:
                    registerUser(service, scanner);
                    break;
                case 2:
                    loginUser(service, scanner);
                    break;
                case 3:
                    exit1 = false;
                    break;
                case 4:
                    System.out.println("Enter your username:");
                    String username = scanner.next();
                    System.out.println("Enter your phone number:");
                    int phoneNumber = scanner.nextInt();
                    System.out.println("Enter your new password:");
                    String newPassword = scanner.next();
                    if (service.validatePhoneNumber(username, phoneNumber, newPassword)) {
                        System.out.println("Password reset successful!");
                    } else {
                        System.out.println("Invalid username or phone number!");
                    }

                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void registerUser(Service service, Scanner scanner) {
        System.out.println("Enter your name:");
        String username = scanner.next();
        System.out.println("Enter your email:");
        String useremail = scanner.next();
        System.out.println("Enter your password:");
        String userpassword = scanner.next();
        System.out.println("enter your phone number");
        long user_phoneno = scanner.nextLong();
        UserReg userReg = new UserReg(username, useremail, userpassword, user_phoneno);
        service.addUserDetails(userReg);
        System.out.println("Job seeker's registration successfully done");
    }

    private static void loginUser(Service service, Scanner scanner) {
        System.out.println("Enter username:");
        username = scanner.next();
        System.out.println("Enter password:");
        password = scanner.next();
        if (service.validateUser(username, password)) {
            System.out.println("Login successful!");

            System.out.println("1.CREATE RESUME");
            System.out.println("2.SEARCH FOR JOBS");
            System.out.println("3.CHECK RESUME");
            System.out.println("4.JOBS APPLIED");
            System.out.println("5.WITHDRAW APPLICATION");
            System.out.println("6.EXIT PAGE");
            System.out.println("ENTER YOUR CHOICE");
            int CHOICE=scanner.nextInt();
            switch(CHOICE){
                case 1:
                    System.out.println("enter your name");
                    String firstname=scanner.next();
                    System.out.println("enter your last name");
                    String Lastname=scanner.next();
                    System.out.println("enter DOB");
                    String dob=scanner.next();
                    System.out.println("enter your mail");
                    String mail=scanner.next();
                    System.out.println("enter the contact number");
                    long phoneno=scanner.nextLong();
                    System.out.println("enter the highest education");
                    String highereducation=scanner.next();
                    System.out.println("enter your cgpa or %");
                    int marks=scanner.nextInt();
                    System.out.println("resume added successfully!!!!!!!!!!!");
                    scanner.nextLine();
                    Resume r = new Resume(firstname,Lastname,dob,mail,phoneno,highereducation,marks);
                    service.addResume(username,password,r);

            }





        } else {
            System.out.println("Invalid username or password!");
        }
    }

    private static void employeeOperations(Service service, Scanner scanner) {
        boolean exit2 = true;
        while (exit2) {
            System.out.println("Choose operation:");
            System.out.println("1. Employee register");
            System.out.println("2. Employee login");
            System.out.println("3. Back to main menu");
            int choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    registerEmployee(service, scanner);
                    break;
                case 2:
                    loginEmployee(service, scanner);
                    break;
                case 3:
                    exit2 = false;
                    break;
                default:
                    System.out.println("Invalid choice!");

            }
        }
    }

    private static void registerEmployee(Service service, Scanner scanner) {
        System.out.println("enter company name:");
        String company= scanner.next();
        System.out.println("Enter user name:");
        String username = scanner.next();
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println("Enter employee key:");
        String emp_key = scanner.next();
        Employeereg employeereg = new Employeereg(company,username,email,emp_key);
        service.addEmployeeDetails(employeereg);
        System.out.println("Employee registration successfully done");
    }

    private static void loginEmployee(Service service, Scanner scanner) {
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println("Enter employee key:");
        String emp_key = scanner.next();
        if (service.validateEmployee(email, emp_key)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid email or employee key!");
        }
    }
//    private static void Resume(Service service, Scanner scanner) {
//
//        int choice_out = scanner.nextInt();
//        switch (choice_out){
//            case 5:
//                viewAllResumes(service);
//                break;
//            case 6:
//                addResume(service, scanner);
//                break;
//            case 7:
//                updateResume(service, scanner);
//                break;
//            case 8:
//                deleteResume(service, scanner);
//                break;
//
//        }
//    }

//    private static void viewAllResumes(Service service) {
//    }
//
//    private static void addResume(Service service, Scanner scanner) {
//
//    }
//
//    private static void updateResume(Service service, Scanner scanner) {
//
//    }
//
//    private static void deleteResume(Service service, Scanner scanner) {
//
//    }
    private static void JobListings(Service service, Scanner scanner) {

        int choice2 = scanner.nextInt();
        switch (choice2) {
            case 4:
                viewAllJobListings(service);
                break;
            case 5:
                addJobListing(service, scanner);
                break;
            case 6:
                updateJobListing(service, scanner);
                break;
            case 7:
                deleteJobListing(service, scanner);
                break;

        }
    }

    private static void viewAllJobListings(Service service) {
    }

    private static void addJobListing(Service service, Scanner scanner) {

    }

    private static void updateJobListing(Service service, Scanner scanner) {

    }

    private static void deleteJobListing(Service service, Scanner scanner) {

    }
    }























