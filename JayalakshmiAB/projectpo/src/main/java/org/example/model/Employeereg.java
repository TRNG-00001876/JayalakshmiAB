package org.example.model;

public class Employeereg {
    private String company;
    private String username;
    private String email;
    private String emp_key;

    public Employeereg(String company, String username, String email, String emp_key) {
        this.company = company;
        this.username = username;
        this.email = email;
        this.emp_key = emp_key;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmp_key() {
        return emp_key;
    }

    public void setEmp_key(String emp_key) {
        this.emp_key = emp_key;
    }
}



