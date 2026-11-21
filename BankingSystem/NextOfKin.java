package BankingSystem;

import java.time.LocalDate;

public class NextOfKin {
    
    private int idNumber;
    private String forenames;
    private String lastname;
    private LocalDate dateOfBirth;
    private char gender;
    private int phoneNumber;
    private String postalAddress;
    private String homeAddress;

    public NextOfKin() {
        idNumber = 0;
        forenames = "";
        lastname = "";
        dateOfBirth = null;
        gender = ' ';
        phoneNumber = 0;
        postalAddress = "";
        homeAddress = "";
    }

    public NextOfKin(int idNumber, String forenames, String lastname, LocalDate dateOfBirth, char gender, int phoneNumber, String postalAddress, String homeAddress) {
        this.idNumber = idNumber;
        this.forenames = forenames;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
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

    public void setGender(char gender) {
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }


    public String toString() {
    return "NEXT OF KIN DETAILS\n" +
            "------------------------" +
            "\nID Number: " + idNumber +
            "\nForenames: " + forenames +
            "\nLastname: " + lastname +
            "\nGender: " + gender +
            "\nPhone Number: " + phoneNumber +
            "\nPostal Address: " + postalAddress +
            "\nHome Address: " + homeAddress
            ;
    }

}


