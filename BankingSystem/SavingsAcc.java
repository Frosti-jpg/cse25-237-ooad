package BankingSystem;

import java.time.LocalDate;

public class SavingsAcc extends BankAcc {
    
    private LocalDate lastInterestDate;
    private LocalDate lastInterestAccumulation;
    private LocalDate lastWithdrawDate;
    private LocalDate nextWithdrawDate;
    
    private double accumulatedInterest;
    private double monthlyAccumulatedInterest;
    private final double percentageDailyInterest;  //0.0005 percent monthly interest, so 0.0060875 per 365.25 days(accounting for the leap year, eqating to 0.0000166667 per day.)

    public SavingsAcc() {

        lastInterestDate = null;
        lastInterestAccumulation = null;
        lastWithdrawDate = null;
        nextWithdrawDate = null;

        accumulatedInterest = 0.0;
        monthlyAccumulatedInterest = 0.0;
        percentageDailyInterest = 0.0;
    }

    public SavingsAcc(int accountNo, String branch, Customer customer) {
        super(accountNo, branch, customer);

        this.accumulatedInterest = 0.0;
        monthlyAccumulatedInterest = 0.0;
        this.percentageDailyInterest = 0.0000166667;
        this.lastInterestDate = LocalDate.now();
        lastInterestAccumulation = LocalDate.now();
        this.lastWithdrawDate = LocalDate.now();
        this.nextWithdrawDate = lastWithdrawDate.plusYears(2);
    }


     //setters


    //getters

    public  LocalDate getNextWithrawalDate() {
        return nextWithdrawDate;
    }

    public LocalDate getLastWithdralDate() {
        return lastWithdrawDate;
    }

    public LocalDate getLastInterestDate() {
        return lastInterestDate;
    }

    public double getAccumulatedInterest() {
        return accumulatedInterest;
    }


    //uncategorised

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
        if (lastWithdrawDate.isBefore(nextWithdrawDate)) {
            System.out.println("Error: Cannot withraw from this account until " + nextWithdrawDate);
            return;
        }

        subtractFromBalance(amount); //remove from balance
        this.lastWithdrawDate = LocalDate.now();
        this.nextWithdrawDate = lastWithdrawDate.plusYears(2);
    }

    public void creditInterest() {  //actually adds interest to the principle
        LocalDate tempLastInterestCredit = lastInterestDate;
        LocalDate todaysDate = LocalDate.now();
        int tempDayCounter = 0;

        //Checks whether it is the first 10 days of the month
        if (todaysDate.getDayOfMonth() >= 1 && todaysDate.getDayOfMonth() <= 10) {
           do {  //Counts the days
                tempDayCounter++;
                tempLastInterestCredit = tempLastInterestCredit.plusDays(1);
            } while (!tempLastInterestCredit.equals(todaysDate));

            // Additional conddition to make sure its been over 15 days
            if (tempDayCounter > 15) {
                addToBalance(monthlyAccumulatedInterest);
                accumulatedInterest += monthlyAccumulatedInterest;
                monthlyAccumulatedInterest = 0.0;
                this.lastInterestDate = todaysDate;
                return;
            } else {
                System.out.println("Error: Can not credit interest now, wait until first week of next month.");
                return;
            }
        }
    }



    public void accumulateInterest() {  //calculates value of interest
        int daysCounter = 0;
        LocalDate tempInterestAccumulationDate = lastInterestAccumulation;

        if (lastInterestAccumulation.isEqual(LocalDate.now())) {  //Checks that last intrest accumulation date was not today
            System.out.println("Error: Unable to credit more than once a day.");
            return;
        } else if (lastInterestAccumulation.isAfter(LocalDate.now())) {  //Checks that last interest accumulation day was not in the future somehow
            System.out.println("Error: Unexpected Bounds, something went wrong.");
            return;
        } else {
            do {  //Counts the days since the last accumulation
                daysCounter++;
                tempInterestAccumulationDate = tempInterestAccumulationDate.plusDays(1);
            } while (!tempInterestAccumulationDate.equals(LocalDate.now()));
            
            //Calculates the value of Interest
            double tempAccountBalance = getBalance();
            double tempAccumulatedInterest = (tempAccountBalance * percentageDailyInterest * daysCounter)/100;
            
            //Increments to the accumulator and resets last date
            this.monthlyAccumulatedInterest += tempAccumulatedInterest;
            lastInterestAccumulation = LocalDate.now();
            return;
        }
    }

}
 