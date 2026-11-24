package BankingSystem;

import java.time.LocalDate;

public class ChequeAcc extends BankAcc {

  private final double depositFee = 1.0;
  private final double withdrawalFeePercent = 0.01;

  private double transactionLimit;
  private double monthlyTransactionSum; //Makes sure you are not hitting the mothly limit

  private LocalDate lastTransactionSumReset;

  //No Arg Constructor
  
  public ChequeAcc() {
    transactionLimit = 10000.0;
    monthlyTransactionSum = 0.0;

    lastTransactionSumReset = null;
  }
  
  //Parameterised Constructor
  
  public ChequeAcc(String accountNo, String branch, Customer customer) {
    super(accountNo, branch, customer);
    
    transactionLimit = 10000.0;
    monthlyTransactionSum = 0.0;

    lastTransactionSumReset = LocalDate.now();
  }
  

  //setters
  
  public void setTransactionLimit(double transactionLimit) {
    this.transactionLimit = transactionLimit;
  }

  public void setLastTransactionSumReset(LocalDate lastTransactionSumReset) {
    this.lastTransactionSumReset = lastTransactionSumReset;
  }

  public void setMonthlyTransactionSum(double monthlyTransactionSum) {
      this.monthlyTransactionSum = monthlyTransactionSum;
  }
  
  //getters
      
  public double getTransactionLimit() {
    return transactionLimit;
  }

  public LocalDate getLastTransactionSumReset() {
    return lastTransactionSumReset;
  }

  public double getMonthlyTransactionSum() {
      return monthlyTransactionSum;
  }

  
  //uncategorised

  @Override 
public void withdraw(double amount) {

    double currentBalance = super.getBalance();  //retrives balance
    double percentageFee = amount * withdrawalFeePercent;  //calculates 1% of withdrawl amount
    LocalDate nextTransactctionSumReset = lastTransactionSumReset.plusMonths(1);

    if (monthlyTransactionSum + amount > transactionLimit) {
      if (lastTransactionSumReset.isBefore(nextTransactctionSumReset)) {
        System.out.println("Error: Monthly Transaction limit exceeded, try again after " + nextTransactctionSumReset);
        return;
      } else {
        lastTransactionSumReset = LocalDate.now(); //The limitation being here, if I look at it that way, is it will reset even i fbalance is insufficient, it's a pre check.
      }
    }

    if (amount <= 0) {
      System.out.println("Error: Invalid transaction amount.");
      return;
    } else if (amount + percentageFee > currentBalance) {
      System.out.println("Error: Insufficient account balance to perform this action.");
      return;
    } else {
      double creditedAmount = amount + percentageFee;  //calculate credited amount
      super.subtractFromBalance(creditedAmount);  //Subtracting the requested withdraw amount with the percentage applied from account balance
      monthlyTransactionSum += amount;  //adding to the transaction counter

      System.out.println("Message: Withdraw Successful.");

      //Time for the TransactionHistory :D.....
    }
  }


  @Override 
  public void deposit(double amount) {
    LocalDate nextTransactctionSumReset = lastTransactionSumReset.plusMonths(1);

    if (monthlyTransactionSum + amount > transactionLimit) {
      if (lastTransactionSumReset.isBefore(nextTransactctionSumReset)) {
        System.out.println("Error: Monthly Transaction limit exceeded, try again after " + nextTransactctionSumReset);
        return;
      } else {
        lastTransactionSumReset = LocalDate.now(); //The limitation being here, if I look at it that way, is it will reset even i fbalance is insufficient, it's a pre check.
      }
    }

    if (amount <= depositFee) {
      System.out.println("Error: Deposit amount too low, please deposit atleast BWP3.00");
      return;
    } else {
      double creditedAmount = amount - depositFee; //crediting the fees
      super.addToBalance(creditedAmount); //add money to account balance
      monthlyTransactionSum += amount; //adding to the transactionCounter

      System.out.println("Message: Deposit Successful.");
      return;
    }
  }

  
  public void Transfer(double amount, Individual individual) {
    double currentBalance = super.getBalance();
    LocalDate nextTransactctionSumReset = lastTransactionSumReset.plusMonths(1);


    if (monthlyTransactionSum + amount > transactionLimit) {  //Checks that we have not exceeded the monthly limit
      if (lastTransactionSumReset.isBefore(nextTransactctionSumReset)) {  //Resets limit when it is time.
        System.out.println("Error: Monthly Transaction limit exceeded, try a smaller amount or try again after " + nextTransactctionSumReset);
        return;
      } else {
        lastTransactionSumReset = LocalDate.now(); //The limitation being here, if I look at it that way, is it will reset even i fbalance is insufficient, it's a pre check.
      }
    }

    if (amount <= 0) {
      System.out.println("Error: Invalid amount entered.");
      return;
    } else if (amount > currentBalance) {
      System.out.println("Error: Insufficient Funds.");
      return;
    } else {
      if (individual.getChequeAcc() == null) {
        System.out.println("Error: Specified recipient does not exist, check account number again.");
        return;
      } else if (amount + individual.getChequeAcc().getMonthlyTransactionSum() > individual.getChequeAcc().getTransactionLimit()) {
        System.out.println("Error: Recipient cannot recieve funds right now, contact bank.");
        return;
      } else {
        individual.getChequeAcc().addToBalance(amount);
        double tempRecipeientMonthlySum = individual.getChequeAcc().getMonthlyTransactionSum();
        individual.getChequeAcc().setMonthlyTransactionSum(tempRecipeientMonthlySum + amount);

        super.subtractFromBalance(amount);
        monthlyTransactionSum += amount;

        System.out.println("Message: Transfer Successful!");
        return;

        //Lastly here would be to add Transaction history and pass to the method in the recipient as wel
      }
    }
  }
}
