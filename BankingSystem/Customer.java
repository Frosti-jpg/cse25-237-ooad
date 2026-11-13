package BankingSystem;

public abstract class Customer {

   private SavingsAcc savingsAcc;
   private InvestmentAcc investmentAcc;
   
   public Customer() {
      savingsAcc = null;
      investmentAcc = null;
   }

   public Customer(SavingsAcc savingsAcc, InvestmentAcc investmentAcc) {
      this.savingsAcc = savingsAcc;
      this.investmentAcc = investmentAcc;
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

   
   public abstract void getCustomerDetails();



   //open Accounts

   public void openSavingsAcc(int accountNo, String branch, Customer customer) {
      if (this.savingsAcc == null) {
         this.savingsAcc = new SavingsAcc(accountNo, branch, customer);
         return;
      } else {
         System.out.println("Error: Account already exists.");
         return;
      }
   }

   public void openInvestmentAcc(int accountNo, String branch, Customer customer) {
      if (investmentAcc == null) {
         this.investmentAcc = new InvestmentAcc(accountNo, branch, customer);
         return;
      } else {
         System.out.println("Error: Account already exists.");
         return;
      }
      
   }

}