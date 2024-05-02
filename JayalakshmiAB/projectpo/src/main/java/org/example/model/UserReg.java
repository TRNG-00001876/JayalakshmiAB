package org.example.model;

public class UserReg {

    private String username;
    private String userpassword;
    private String useremail;
    private long user_phoneno;

    public UserReg( String username, String useremail, String userpassword, long user_phoneno) {
        this.username = username;
        this.useremail = useremail;
        this.userpassword = userpassword;
        this.user_phoneno = user_phoneno;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public long getUser_phoneno() {
        return user_phoneno;
    }

    public void setUser_phoneno(long user_phoneno) {
        this.user_phoneno = user_phoneno;
    }
}

