package org.example.model;

public class JobListing {
    private static int JobID;
    private static String JobTitle;
    private static String Companyname;
    private static String Loc;
    private static int experience;
    public JobListing(int JobID, String JobTitle, String Companyname, String Loc, int experience)  {
        this.JobID = JobID;
        this.JobTitle = JobTitle;
        this.Companyname = Companyname;
        this.Loc =Loc;
        this.experience=experience;
    }

    public static int getJobID() {
        return JobID;
    }

    public static void setJobID(int jobID) {
        JobID = jobID;
    }

    public static String getJobTitle() {
        return JobTitle;
    }

    public static void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public static String getCompanyname() {
        return Companyname;
    }

    public static void setCompanyname(String companyname) {
        Companyname = companyname;
    }

    public static String getLoc() {
        return Loc;
    }

    public static void setLoc(String loc) {
        Loc = loc;
    }

    public static int getExperience() {
        return experience;
    }

    public static void setExperience(int experience) {
        JobListing.experience = experience;
    }

}
