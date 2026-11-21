package BankingSystem;

import java.util.ArrayList;


public class Company extends Customer {
    
    private String companyName;
    private String companyType;
    private String companyPhysicalAddress;
    private int companyTelephone;
    private ArrayList<Shareholder> shareholder;
    private  double yearlyTurnover;

    public Company() {
        companyName = "";
        companyType = "";
        companyPhysicalAddress = "";
        companyTelephone = 0;

        yearlyTurnover = 0;

        shareholder = new ArrayList<>();
    }

    public Company(String companyName, String companyType, String companyPhysicalAddress, int companyTelephone, int yearlyTurnover) {
        this.companyName = companyName;
        this.companyType =companyType;
        this.companyPhysicalAddress = companyPhysicalAddress;
        this.companyTelephone = companyTelephone;

        this.yearlyTurnover = yearlyTurnover;

        shareholder = new ArrayList<>();
    }

    //setters

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public void setCompanyPhysicalAddress(String companyPhysicalAddress) {
        this.companyPhysicalAddress = companyPhysicalAddress;
    }

    public void setCompanyTelephone(int companyTelephone) {
        this.companyTelephone = companyTelephone;
    }


    public void setYearlyTurnover(double yearlyTurnover) {
        this.yearlyTurnover = yearlyTurnover;
    }

    public void setShareholder(ArrayList<Shareholder> shareholder) {
        this.shareholder = shareholder;
    }

    //getters

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getCompanyPhysicalAddress() {
        return companyPhysicalAddress;
    }

    public int getCompanyTelephone() {
        return companyTelephone;
    }


    public double getYearlyTurnover() {
        return yearlyTurnover;
    }

    public ArrayList<Shareholder> getShareholder() {
        return shareholder;
    }


    @Override 
    public String getCustomerDetails() {
        return "PERSONAL DETAILS\n" +
                "------------------------" +
                "\nCompany Name: " + companyName +
                "\nCompany Type: " + companyType +
                "\nCompany Physical Address: " + companyPhysicalAddress +
                "\nCompany Telephone: " + companyTelephone +
                "\nYearly Turnover: " + yearlyTurnover +
                
                "\n\nSHAREHOLDER DETAILS" +
                "------------------------\n" +
                shareholder.toString() +

                "\n\nBANK ACCOUNT DETAILS" +
                "------------------------" +
                "\nINVESTMENT ACCOUNT" + 
                super.getInvestmentAcc() +
                "\nSAVING ACCOUNT" +
                super.getSavingsAcc()
                ;
    }

}
