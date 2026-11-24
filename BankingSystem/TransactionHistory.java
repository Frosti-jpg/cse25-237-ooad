package BankingSystem;

import java.time.LocalDate;

public class TransactionHistory {
    
    private String accountNumber;
    private String accountType;
    private LocalDate transactionDate;
    private String transactionType;
    private double transactionAmount;
    private double balanceAfter;
    private double balanceBefore;

    public TransactionHistory() {
        accountNumber = "";
        accountType = "";
        transactionDate = null;
        transactionType = "";
        transactionAmount = 0.0;
        balanceAfter = 0;
        balanceBefore = 0;
    }

    public TransactionHistory(double transactionAmount, double balanceAfter,String accountType, String transactionType, String accountNumber) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.transactionDate = LocalDate.now();
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.balanceAfter = balanceAfter;
        this.balanceBefore = balanceAfter - transactionAmount;
    }


    //setters

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalanceBefore(double balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    //getters

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalanceBefore() {
        return balanceBefore;
    }

    
    public String toString() {
        return "AccountNo: " + accountNumber +
                "\nAccount Type: " + accountType +
                "\nDate: " + transactionDate +
                "\n\n--------------------------------------\n\n" +
                "Transfer Type: " + transactionType + "\n" +
                transactionType + " Amount: BWP" + transactionAmount +
                "\n\n--------------------------------------\n\n" +
                "Amount Before " + transactionType + ": BWP" + balanceAfter +
                "\n\nAvailable Balance: BWP" + balanceAfter
        ;
    }
}