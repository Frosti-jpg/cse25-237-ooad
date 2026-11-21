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
    private String relationship;

    public NextOfKin() {
        idNumber = 0;
        forenames = "";
        lastname = "";
        dateOfBirth = null;
        gender = ' ';
        phoneNumber = 0;
        postalAddress = "";
        homeAddress = "";
        relationship = "";
    }

    public NextOfKin(int idNumber, String forenames, String lastname, LocalDate dateOfBirth, char gender, int phoneNumber, String postalAddress, String homeAddress, String relationship) {
        this.idNumber = idNumber;
        this.forenames = forenames;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.postalAddress = postalAddress;
        this.homeAddress = homeAddress;
        this.relationship = relationship;
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

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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

    public String getRelationship() {
        return relationship;
    }

    public String toString() {
    return  "\nID Number: " + idNumber +
            "\nForenames: " + forenames +
            "\nLastname: " + lastname +
            "\nGender: " + gender +
            "\nPhone Number: " + phoneNumber +
            "\nPostal Address: " + postalAddress +
            "\nHome Address: " + homeAddress +
            "\nRelationship: " + relationship + "\n"
            ;
    }

}