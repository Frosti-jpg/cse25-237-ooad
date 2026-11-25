package BankingSystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Individual extends Customer {
    
    private String idNumber;
    private String forenames;
    private String lastname;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String nationality;
    private char gender;
    private String eyeColour;
    private String phoneNumber;
    private String postalAddress;
    private String homeAddress;
    private ArrayList<NextOfKin> nextOfKin;
    private ArrayList<AdditionalIncomeSources> additionalIncomeSources;
    private Employment employment;

    private ChequeAcc chequeAcc;

    public Individual() {
        idNumber = "";
        forenames = "";
        lastname = "";
        dateOfBirth = null;
        placeOfBirth = "";
        nationality = "";
        gender = ' ';
        eyeColour = "";
        phoneNumber = "";
        postalAddress = "";
        homeAddress = "";
        nextOfKin = new ArrayList<>();
        additionalIncomeSources = new ArrayList<>();
        
        employment = null;
        chequeAcc = null;
    }

    public Individual(String idNumber, String forenames, String lastname, int year, int month, int day, String placeOfBirth, String nationality, char gender, String eyeColour, String phoneNumber, String postalAddress, String homeAddress) {
        this.idNumber = idNumber;
        this.forenames = forenames;
        this.lastname = lastname;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.placeOfBirth = placeOfBirth;
        this.nationality = nationality;
        this.gender = gender;
        this.eyeColour = eyeColour;
        this.phoneNumber = phoneNumber;
        this.postalAddress = postalAddress;
        this.homeAddress = homeAddress;

        this.nextOfKin = new ArrayList<>();
        this.additionalIncomeSources = new ArrayList<>();

    }

    //setters

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setForenames(String forenames) {
        this.forenames = forenames;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public void setChequeAcc(ChequeAcc chequeAcc) {
        this.chequeAcc = chequeAcc;
    }

    public void setNextOfKin(ArrayList<NextOfKin> nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public void setAdditionalIncomeSources(ArrayList<AdditionalIncomeSources> additionalIncomeSources) {
        this.additionalIncomeSources = additionalIncomeSources;
    }


    //getters

    public String getIdNumber() {
        return idNumber;
    }

    public String getForenames() {
        return forenames;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        LocalDate todaysDate = LocalDate.now();
        int tempYearOfBirth = dateOfBirth.getYear();
        int tempCurrentYear = todaysDate.getYear();

        return tempCurrentYear - tempYearOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public char getGender() {
        return gender;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public ChequeAcc getChequeAcc() {
        return chequeAcc;
    }

    public Employment getEmployment() {
        return employment;
    }

    public ArrayList<NextOfKin> getNextOfKin() {
        return nextOfKin;
    }

    public ArrayList<AdditionalIncomeSources> getAdditionalIncomeSources() {  //returns the ArrayList
        return additionalIncomeSources;
    }

    @Override 
    public String getCustomerDetails() {

        return "PERSONAL DETAILS\n" +
                "------------------------" +
                "\nID Number: " + idNumber +
                "\nForenames: " + forenames +
                "\nLastname: " + lastname +
                "\nNationality: " + nationality +
                "\nGender: " + gender +
                "\nEye Colour: " + eyeColour +
                "\nPhone Number: " + phoneNumber +
                "\nPostal Address: " + postalAddress +
                "\nHome Address: " + homeAddress +
                "\n\nNEXT OF KIN DETAILS" +
                "------------------------" +
                nextOfKin.toString() +
                "\n\nBANK ACCOUNT DETAILS\n" +
                "------------------------\n\n" +
                "CHEQUE ACCOUNT\n" +
                checkForAccount(getChequeAcc(), "Cheque Account") +
                "\nINVESTMENT ACCOUNT\n" + 
                checkForAccount(getInvestmentAcc(), "Investment Account") +
                "\nSAVING ACCOUNT\n" +
                checkForAccount(getSavingsAcc(), "Savings Account")
                ;
    }

    public String checkForAccount(BankAcc bankAcc, String accountType) {
        if (bankAcc == null) {
            return "Message: " + accountType + " has not been opened yet.";
        } else {
            return bankAcc.toString();
        }
    }

    public String checkForAccountHistory(BankAcc bankAcc, String accountType) {
        if (bankAcc == null) {
            return "Message: " + accountType + " has not been opened yet.";
        } else {
            return bankAcc.getTransactionHistory().toString();
        }
    }

    public String getAllTransactionHistory() {
      return "CHEQUE ACCOUNT" +
         "\n-----------------------------\n" +
         checkForAccountHistory(getChequeAcc(), "Cheque Account") +
         "SAVINGS ACCOUNT" +
         "\n-----------------------------\n" +
         checkForAccountHistory(getSavingsAcc(), "Cheque Account") +
         "INVESTMENT ACCOUNT" +
         "\n-----------------------------\n" +
         checkForAccountHistory(getInvestmentAcc(), "Cheque Account")
      ;
   }


   public void openChequeAcc(String accountNo, String branch) {
      if (chequeAcc == null) {
         this.chequeAcc = new ChequeAcc(accountNo, branch, this);
         return;
      } else {
        System.out.println("Error: Account already exists.");
         return;
      }
      
   }

    public void addNextOfKin(int idNumber, String forenames, String lastname, LocalDate dateOfBirth, char gender, int phoneNumber, String postalAddress, String homeAddress, String relationship) {
        this.nextOfKin.add(new NextOfKin(idNumber, forenames, lastname, dateOfBirth, gender, phoneNumber, postalAddress, homeAddress, relationship));
    }
    

    public void addAdditionalIncomeSources(String sourceOfIncome) {
        this.additionalIncomeSources.add(new AdditionalIncomeSources(sourceOfIncome));
    }
}