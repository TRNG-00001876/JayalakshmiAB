package org.example;

import org.example.dao.User;
import org.example.dao.UserImp;
import org.example.model.EmployerModel;
import org.example.model.JobModel;
import org.example.service.EmployerService;
import org.example.service.JobSeekerService;

import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Connection connection;
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost;databaseName=ProjectP0;integratedSecurity=true;encrypt=true;trustServerCertificate=true";

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url);
            logger.info("Connected to the database.");

            User userDAO = UserImp.getJobSeekerInstance(connection);
            EmployerService employerService = new EmployerService(userDAO);
            JobSeekerService jobSeekerService = new JobSeekerService(userDAO);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("job portal");
                System.out.println("1.Job Seeker");
                System.out.println("2.Employer");
                System.out.println("3.Exit");

                int choice;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input");
                    scanner.nextLine();
                    break;
                }

                switch (choice) {
                    case 1:
                        System.out.println("perform your opertion");
                        System.out.println("1.job seeker's login");
                        System.out.println("2.job seeker's Registeration");
                        int innerJsChoice;
                        try {
                            innerJsChoice = scanner.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid Input");
                            scanner.nextLine();
                            break;
                        }

                        switch (innerJsChoice) {
                            case 1:
                                jobSeekerService.validateJobSeekerLogin();
                                break;
                            case 2:

                                System.out.println("Enter Your User Name:");
                                String userName = scanner.next();
                                String dob;
                                String invalidDobMessage;
                                do {
                                    System.out.println("Enter Your Date Of Birth (dd/mm/yyyy):");
                                    dob = scanner.next();
                                    invalidDobMessage = isValidDOBMessage(dob);
                                    if (!invalidDobMessage.isEmpty()) {
                                        System.out.println(invalidDobMessage);
                                    }
                                } while (!invalidDobMessage.isEmpty());

                                System.out.println("Enter Your User Email:");
                                String email = scanner.next();
                                while (!isValidEmail(email)) {
                                    System.out.println("Invalid format. Enter a valid pattern:");
                                    email = scanner.next();
                                }

                                System.out.println("Enter Your User Password:");
                                String password = scanner.next();
                                JobModel jobModel = new JobModel(userName, dob, email, password);
                                jobSeekerService.JobSeekerRegister(jobModel);
                                break;
                            default:
                                System.out.println("Enter Valid Choice");
                        }
                        break;
                    case 2:
                        System.out.println("Enter Your Choice To Proceed");
                        System.out.println("1.Login");
                        System.out.println("2.Register");
                        int innerEmpChoice;
                        try {
                            innerEmpChoice = scanner.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid Input Format");
                            scanner.nextLine();
                            break;
                        }

                        switch (innerEmpChoice) {
                            case 1:
                                employerService.validateEmployerLogin();
                                break;
                            case 2:
                                System.out.println("Enter Your User Name:");
                                String user_name=scanner.next();
                                System.out.println("Enter Your Department");
                                String dob=scanner.next();
                                System.out.println("Enter Your User Email:");
                                String email = scanner.next();
                                while (!isValidEmail(email)) {
                                    System.out.println("Invalid email format. Enter a valid email:");
                                    email = scanner.next();
                                }
                                System.out.println("Enter Your Company Name");
                                String company_name=scanner.next();
                                System.out.println("Enter Your User Password:");
                                String password=scanner.next();

                                EmployerModel employerModel=new EmployerModel(user_name,dob,email,company_name,password);
                                employerService.EmployerRegister(employerModel);
                                break;
                            default:
                                System.out.println("Enter Valid Choice");
                        }
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Connection Error: " + e.getMessage());
            System.out.println("Connection Error: " + e.getMessage());
        }
    }

    private static String isValidDOBMessage(String dob) {
        String dobRegex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(dobRegex);
        Matcher matcher = pattern.matcher(dob);
        if (matcher.matches()) {
            return "";
        } else {
            return "Invalid date pattern :";
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
