package BankingSystem;

public class Company extends Customer {
    
    public String companyName;
    public String companyType;
    public String companyPhysicalAddress;
    public int companyTelephone;
    //public Shareholders[] shareholders;
    public double yearlyTurnover;

    public Company() {
        companyName = "";
        companyType = "";
        companyPhysicalAddress = "";
        companyTelephone = 0;

        yearlyTurnover = 0;
    }

    public Company(String companyName, String companyType, String companyPhysicalAddress, int companyTelephone, int yearlyTurnover) {
        this.companyName = companyName;
        this.companyType =companyType;
        this.companyPhysicalAddress = companyPhysicalAddress;
        this.companyTelephone = companyTelephone;

        this.yearlyTurnover = yearlyTurnover;
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



}
