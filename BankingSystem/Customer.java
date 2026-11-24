package BankingSystem;

import java.util.ArrayList;

public abstract class Customer {

   private SavingsAcc savingsAcc;
   private InvestmentAcc investmentAcc;
   private ArrayList<TransactionHistory> transactionHistory;
   
   public Customer() {
      savingsAcc = null;
      investmentAcc = null;
      transactionHistory = new ArrayList<>();
   }

   public Customer(SavingsAcc savingsAcc, InvestmentAcc investmentAcc) {
      this.savingsAcc = savingsAcc;
      this.investmentAcc = investmentAcc;
      transactionHistory = new ArrayList<>();
   }


   //setters

   public void setSavingsAcc(SavingsAcc savingsAcc) {
      this.savingsAcc = savingsAcc;
   }

   public void setInvestmentAcc(InvestmentAcc investmentAcc) {
      this.investmentAcc = investmentAcc;
   }


   //getters

   public SavingsAcc getSavingsAcc() {     //remember, when I get the class, I have to method chain, I invoke this get method, then the get method from the next class
      return savingsAcc;
   }

   public InvestmentAcc getInvestmentAcc() {
      return investmentAcc;
   }

   public ArrayList<TransactionHistory> getTransactionHistory() {
       return transactionHistory;
   }


   public abstract String getCustomerDetails();



   //open Accounts

   public void openSavingsAcc(String accountNo, String branch) {
      if (this.savingsAcc == null) {
         this.savingsAcc = new SavingsAcc(accountNo, branch, this);
         return;
      } else {
         System.out.println("Error: Account already exists.");
         return;
      }
   }

   public void openInvestmentAcc(String accountNo, String branch) {
      if (investmentAcc == null) {
         this.investmentAcc = new InvestmentAcc(accountNo, branch, this);
         return;
      } else {
         System.out.println("Error: Account already exists.");
         return;
      }
      
   }

}