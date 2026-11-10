package BankingSystem;

public class ChequeAcc extends BankAcc {

   private final double depositFee;
   private double depositCounter;
   private final double withdrawFee;
   private double transactionLimit;
   private double transactionCounter; //Makes sure you are not hitting the mothly limit

   //No Arg Constructor
   
   public ChequeAcc() {
      depositFee = 1.0;
      depositCounter = 0.0;
      withdrawFee = 2.0;
      transactionLimit = 10000.0;
      transactionCounter = 0.0;
   }
   
   //Parameterised Constructor
   
   public ChequeAcc(int accountNo, String branch, Customer customer) {
      super(accountNo, branch, customer);
      
      depositFee = 1.0;
      depositCounter = 0.0;
      withdrawFee = 2.0;
      transactionLimit = 10000.0;
      transactionCounter = 0.0;
   }
   
   //setters
   
   public void setTransactionLimit(double transactionLimit) {
      this.transactionLimit = transactionLimit;
   }
   
   //getters
      
   public double getTransactionLimit() {
      return transactionLimit;
   }
   
   //uncategorised
   
   public void withdraw(double amount) {
      //if
   }
   
   public void deposit(double amount) {
      
   }
   
}
