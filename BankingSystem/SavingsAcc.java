package BankingSystem;

import java.time.LocalDate;

public class SavingsAcc extends BankAcc {
    
    private LocalDate interestLastCredited; //Stores the last date interest added to balance.
    private LocalDate interestNextCredited; //Stores the next date interest can be added to balance.

    private LocalDate lastAccrualDate; //Stores the date of the last interest accural.
    private double monthlyAccural; //Stores the value of accural awaiting to be credited to balance.
    private double totalAccural; //Stores the total of all the interest gathered on the account.

    private LocalDate lastWithdrawDate;
    private LocalDate nextWithdrawDate;
    
    private final double percentageDailyInterest;  //0.0005 percent monthly interest, so 0.0060875 per 365.25 days(accounting for the leap year, eqating to 0.0000166667 per day.)

    public SavingsAcc() {

        interestLastCredited = null;
        interestNextCredited = null;
        lastAccrualDate = null;
        lastWithdrawDate = null;
        nextWithdrawDate = null;

        totalAccural = 0.0;
        monthlyAccural = 0.0;
        percentageDailyInterest = 0.0;
    }

    public SavingsAcc(int accountNo, String branch, Customer customer) {
        super(accountNo, branch, customer);

        this.totalAccural = 0.0;
        this.monthlyAccural = 0.0;
        this.percentageDailyInterest = 0.00166667;
        this.interestLastCredited = LocalDate.now();
        this.interestNextCredited = interestLastCredited.plusMonths(1);
        this.lastAccrualDate = LocalDate.now();
        this.lastWithdrawDate = LocalDate.now();
        this.nextWithdrawDate = lastWithdrawDate.plusYears(2);
    }

    //Abstract methods
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {  //will check if the amount entered is 1 or above.
            System.out.println("Error: Amount entered is too low.");
            return;
        } else {
            addToBalance(amount);  //adds deposited amount to balance
            return;
        }
    }

    @Override 
    public void withdraw(double amount) {
        double tempBalance = getBalance();

        if (lastWithdrawDate.isBefore(nextWithdrawDate)) {
            System.out.println("Error: Cannot withraw from this account until " + nextWithdrawDate);
            return;
        } else if (tempBalance < amount || amount <= 0) {
            System.out.println("Error: Insufficient Funds or invalid amount input");
            return;
        } else {
        subtractFromBalance(amount); //remove from balance
        this.lastWithdrawDate = LocalDate.now();
        this.nextWithdrawDate = lastWithdrawDate.plusYears(2);
        }
    }

    //getters

    public  LocalDate getNextWithrawalDate() {
        return nextWithdrawDate;
    }

    public LocalDate getLastWithdralDate() {
        return lastWithdrawDate;
    }

    public LocalDate getInterestLastCredited() {
        return interestLastCredited;
    }

    public double getAccumulatedInterest() {
        return totalAccural;
    }

    
    //Interfaces
    
    public void calculateMonthlyInterest() {  //Handles the accrual of the interest
        int daysCounter = 0;
        LocalDate tempLastAccural = lastAccrualDate;
        LocalDate tempTodaysDate = LocalDate.now();

        //Checks whether you aren't performing this more than once a day
        if (lastAccrualDate.isEqual(tempTodaysDate)) {
            System.out.println("Error: Unable to credit more than once a day.");
            return;
        } else if (lastAccrualDate.isAfter(tempTodaysDate)) {  //Validates that the last accural date is not after today.
            System.out.println("Fatal Error: Try again later.");
            return;
        } else {

            //Counts the number of days since the last interest accural
            do {
                daysCounter++;
                tempLastAccural = tempLastAccural.plusDays(1);
            } while (!tempLastAccural.equals(LocalDate.now()));

            //The logic to handle the accumulation
            double tempAccountBalance = getBalance();
            double tempInterestValue = (tempAccountBalance * percentageDailyInterest * daysCounter)/100;

            //Increments to the accumulator and resets last date
            this.monthlyAccural += tempInterestValue;
            this.lastAccrualDate = LocalDate.now();
            return;
        }
    }


    public void creditInterest() {  //Handles adding the accumulated interest value to the balance.
        LocalDate tempTodaysDate = LocalDate.now();

        //Checks whether it has been a month
        if (tempTodaysDate.isBefore(interestNextCredited)) {
            System.out.println("Error: You can ony perform this action on or after " + interestNextCredited);
            return;
        } else {
            addToBalance(monthlyAccural);
            totalAccural += monthlyAccural;
            monthlyAccural = 0.0; //Clears for a new month

            interestLastCredited = LocalDate.now();
            interestNextCredited = interestLastCredited.plusMonths(1);
        }
    }
}