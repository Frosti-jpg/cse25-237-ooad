package BankingSystem;

import java.time.LocalDate;

public class Employment {
    
    public String companyName;
    public String companyAddress;
    public double yearlySalary;
    public String position;
    public LocalDate employmentDate;

    public Employment() {
        companyName = "";
        companyAddress = "";
        yearlySalary = 0.0;
        position = "";
        employmentDate = null;
    }

    public Employment(String companyName, String companyAddress, double yearlySalary, String position, LocalDate employmenDate) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.yearlySalary = yearlySalary;
        this.position = position;
        this.employmentDate = employmenDate;
    }

    //setter

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }


    //getters

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public String getPosition() {
        return position;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public String toString() {
        return "Company Name: " + companyName +
                "\nCompany Address: " + companyAddress +
                "-----------------------------------" +
                "\nJob Position: " + position +
                "\nYearly Salary: " + yearlySalary +
                "\n\nEmployed Since: " + employmentDate;
    }

}
