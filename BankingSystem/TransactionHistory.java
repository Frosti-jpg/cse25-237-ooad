package BankingSystem;

import java.time.LocalDate;

public class TransactionHistory {
    
    private String accountNumber;
    private String accountType;
    private LocalDate transactionDate;
    private String transactionType;
    private double transactionAmount;
    private double transactionFee;
    private double balanceAfter;
    private double balanceBefore;

    public TransactionHistory() {
        accountNumber = "";
        accountType = "";
        transactionDate = null;
        transactionType = "";
        transactionAmount = 0.0;
        transactionFee = 0.0;
        balanceAfter = 0.0;
        balanceBefore = 0.0;
    }

    public TransactionHistory(String accountNumber, String accountType, String transactionType, double transactionAmount, double transactionFee, double balanceAfter, double balanceBefore) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.transactionDate = LocalDate.now();
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionFee = transactionFee;
        this.balanceAfter = balanceAfter;
        this.balanceBefore = balanceBefore;
    }


    //setters

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public void setBalanceBefore(double balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }


    //getters

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public double getBalanceBefore() {
        return balanceBefore;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    
    public String toString() {
        return "\n\nAccountNo: " + accountNumber +
                "\nAccount Type: " + accountType +
                "\nDate: " + transactionDate +
                "\n\n--------------------------------------\n\n" +
                "Transfer Type: " + transactionType + "\n" +
                transactionType + " Amount: BWP" + transactionAmount +
                "\nTransaction Fee: BWP" + transactionFee +
                "\n\n--------------------------------------\n\n" +
                "Amount Before " + transactionType + ": BWP" + balanceBefore +
                "\n\nAvailable Balance: BWP" + balanceAfter
        ;
    }
}