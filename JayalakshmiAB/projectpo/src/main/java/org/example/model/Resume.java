package org.example.model;

public class Resume {
    private String firstname;
    private  String Lastname;
    private  String dob;
    private  String mail;
    private  Long phonenumber;
    private String highereducation;
    private int marks;

    public Resume(String firstname, String lastname, String dob, String mail, Long phonenumber, String highereducation, int marks) {
        this.firstname = firstname;
        Lastname = lastname;
        this.dob = dob;
        this.mail = mail;
        this.phonenumber = phonenumber;
        this.highereducation = highereducation;
        this.marks = marks;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getHighereducation() {
        return highereducation;
    }

    public void setHighereducation(String highereducation) {
        this.highereducation = highereducation;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}



