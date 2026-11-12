package BankingSystem;

import java.time.LocalDate;

abstract class BankAcc {

   private int accountNo;
   private double accountBalance;
   private String branch;
   private Customer customer;
   private final LocalDate dateOpened;    //for implementing a way to credit interest.


   //No Arg Constructor

   public BankAcc() {
      accountNo = 0;
      accountBalance = 0.0;
      branch = "";
      customer = null;
      dateOpened = null;
   }

   //Parameterised Constructor

   BankAcc(int accountNo, String branch, Customer customer) {
      this.accountNo = accountNo;
      this.branch = branch;
      this.customer = customer;
      
      this.accountBalance = 0.0;
      this.dateOpened = LocalDate.now();
   }

   public abstract void withdraw(double amount);
   
   public abstract void deposit(double amount);
   
   //getters
   
   public double getBalance() {
      return accountBalance;
   }

   public int getaccountNo() {
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
