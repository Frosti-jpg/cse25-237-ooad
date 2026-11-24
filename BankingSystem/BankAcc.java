package BankingSystem;

import java.time.LocalDate;
import java.util.ArrayList;

abstract class BankAcc {

   private String accountNo;
   private double accountBalance;
   private String branch;
   private Customer customer;
   private final LocalDate dateOpened;    //for implementing a way to credit interest.

   private ArrayList<TransactionHistory> transactionHistory;



   //No Arg Constructor

   public BankAcc() {
      accountNo = "";
      accountBalance = 0.0;
      branch = "";
      customer = null;
      dateOpened = null;

      transactionHistory = new ArrayList<>();
   }

   //Parameterised Constructor

   BankAcc(String accountNo, String branch, Customer customer) {
      this.accountNo = accountNo;
      this.branch = branch;
      this.customer = customer;
      
      this.accountBalance = 0.0;
      this.dateOpened = LocalDate.now();

      transactionHistory = new ArrayList<>();
   }

   //abstract methods

   public abstract void withdraw(double amount);
   
   public abstract void deposit(double amount);
   

   //setters


   //getters
   
   public double getBalance() {
      return accountBalance;
   }

   public String getaccountNo() {
      return accountNo;
   }
   
   public String getBranch() {
      return branch;
   }
   
   public Customer getCustomer() {
      return customer;
   }

   public LocalDate getDateOpened() {
      return dateOpened;
   }

   public ArrayList<TransactionHistory> getTransactionHistory() {
       return transactionHistory;
   }
   
   public String toString() {
      return "AccountNo: " + accountNo + "\nBranch: " + branch + "\n\nBalance: " + accountBalance + "\n\nAccount Open Since: " +  dateOpened;
   }

   protected void subtractFromBalance(double amount) {
    if (amount>0 && amount<=accountBalance) {
      accountBalance -= amount;
    }
   }

   protected void addToBalance(double amount) {
    if (amount>0) {
      accountBalance += amount;
    }
   }
}
