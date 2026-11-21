package BankingSystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Shareholder {
    
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
    private ArrayList<NextOfKin> nextOfKin;
    private Company company;


    public Shareholder() {
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
        nextOfKin = new ArrayList<>();
        company = null;
    }

    public Shareholder(int idNumber, String forenames, String lastname, LocalDate dateOfBirth, String placeOfBirth, String nationality, char gender, String eyeColour, int phoneNumber, String postalAddress, String homeAddress, Company company) {
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
        this.nextOfKin = new ArrayList<>();
        this.company = company;
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

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setNextOfKin(ArrayList<NextOfKin> nextOfKin) {
        this.nextOfKin = nextOfKin;
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

    public String getPostalAddress() {
        return postalAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public Company getCompany() {
        return company;
    }

    public ArrayList<NextOfKin> getNextOfKin() {
        return nextOfKin;
    }

    public String toString() {
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
                "------------------------\n" +
                nextOfKin.toString()
                ;
    }

    public void addNextOfKin(int idNumber, String forenames, String lastname, LocalDate dateOfBirth, char gender, int phoneNumber, String postalAddress, String homeAddress, String relationship) {
        this.nextOfKin.add(new NextOfKin(idNumber, forenames, lastname, dateOfBirth, gender, phoneNumber, postalAddress, homeAddress, relationship));
    }
    



}