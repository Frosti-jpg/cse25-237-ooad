package BankingSystem;

public class ChequeAcc extends BankAcc {

   private final double depositFee = 1.0;
   private final double withdrawalFeePer100 = 1.0;

   private double transactionLimit;
   private double transactionCounter; //Makes sure you are not hitting the mothly limit

   //No Arg Constructor
   
   public ChequeAcc() {
      transactionLimit = 10000.0;
      transactionCounter = 0.0;
   }
   
   //Parameterised Constructor
   
   public ChequeAcc(int accountNo, String branch, Customer customer) {
      super(accountNo, branch, customer);
      
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
   
   @Override 
   public void withdraw(double amount) {

      double currentBalance = super.getBalance();  //retrives balance
      double percentageFee = amount * 0.01;  //calculates 1% of withdrawl amount 

      if (amount <= 0) {
        System.out.println("Error: Invalid transaction amount.");
        return;
      } else if (transactionCounter + amount > transactionLimit) {
        System.out.println("Error: Monthly Tansaction limit exceeded.");
        return;
      } else if (amount + percentageFee > currentBalance) {
        System.out.println("Error: Insufficient account balance to perform this action.");
        return;
      } else {
        double creditedAmount = amount + percentageFee;  //calculate credited amount
        super.subtractFromBalance(creditedAmount);  //Subtracting the requested withdraw amount with the percentage applied from account balance
        transactionCounter += amount;  //adding to the transaction counter

        System.out.println("Message: Withdraw Successful.");
      }
   }
   
   @Override 
   public void deposit(double amount) {
      if (amount <= depositFee) {
        System.out.println("Error: Deposit amount too low, please deposit atleast BWP3.00");
        return;
      } else if (transactionCounter + amount > transactionLimit) {
        System.out.println("Error: Monthly Transaction limit exceeded.");
        return;
      } else {
        double creditedAmount = amount - depositFee; //crediting the fees
        super.addToBalance(creditedAmount); //add money to account balance
        transactionCounter += amount; //adding to the transactionCounter

        System.out.println("Message: Deposit Successful.");
        return;
      }
   }
   
}
