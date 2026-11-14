package BankingSystem;

import java.time.LocalDate;

public class Individual extends Customer {
    
    private int idNumber;
    private String forenames;
    private String lastname;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String nationality;
    private char gender;
    private String eyeColour;
    private int phoneNumber;
    private String postalAddress;
    private String homeAddress;
    //private NextOfKin[] nextOfKin; //
    //private AdditionalIncomeSources[] additionalIncomeSources;
    private Employment employment;

    private ChequeAcc chequeAcc;

    public Individual() {
        idNumber = 0;
        forenames = "";
        lastname = "";
        dateOfBirth = null;
        placeOfBirth = "";
        nationality = "";
        gender = ' ';
        eyeColour = "";
        phoneNumber = 0;
        postalAddress = "";
        homeAddress = "";
        //nextOfKin = null;
        //additionalIncomeSources = null;
        
        employment = null;
        chequeAcc = null;
    }

    public Individual(int idNumber, String forenames, String lastname, LocalDate dateOfBirth, String placeOfBirth, String nationality, char gender, String eyeColour, int phoneNumber, String postalAddress, String homeAddress) {
        this.idNumber = idNumber;
        this.forenames = forenames;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.nationality = nationality;
        this.gender = gender;
        this.eyeColour = eyeColour;
        this.phoneNumber = phoneNumber;
        this.postalAddress = postalAddress;
        this.homeAddress = homeAddress;

    }

    //setters

    public void setIdNumber(int idNumber) {
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

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    //remaining are the NextOfKin ands AdditionalIncomeSources

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public void setChequeAcc(ChequeAcc chequeAcc) {
        this.chequeAcc = chequeAcc;
    }


    //getters

    public int getIdNumber() {
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public ChequeAcc getChequeAcc() {
        return chequeAcc;
    }

    //remaining is to get uhh a list of all Next Of Kin and Additional Income Sourses

    public Employment employment() {
        return employment;
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

                "\n\nBANK ACCOUNT DETAILS" +
                "------------------------" +
                "CHEQUE ACCOUNT" +
                chequeAcc.toString() +
                "\nINVESTMENT ACCOUNT" + 
                super.getInvestmentAcc() +
                "\nSAVING ACCOUNT" +
                super.getSavingsAcc()
                ;

                //later 3 methods, each returns full transaction history for each account.
    }    

   public void openChequeAcc(int accountNo, String branch) {
      if (chequeAcc == null) {
         this.chequeAcc = new ChequeAcc(accountNo, branch, this);
         return;
      } else {
         System.out.println("Error: Account already exists.");
         return;
      }
      
   }
    
}
