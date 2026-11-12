package BankingSystem;

import java.time.LocalDate;

public class InvestmentAcc extends BankAcc {
    
    private LocalDate lastInterestDate;
    private LocalDate lastWithdrawDate;

    private final double percentageDailyInterest;  //0.05 percent monthly interest, so 0.60875 per 365.25 days(accounting for the leap year, eqating to 0.0016666667 per day.)

    public InvestmentAcc() {
        lastInterestDate = null;
        lastWithdrawDate = null;
        percentageDailyInterest = 0.0;
    }

    public InvestmentAcc(int accountNo, String branch, Customer customer) {
        super(accountNo, branch, customer);

        this.percentageDailyInterest = 0.0016666667;
        this.lastInterestDate = LocalDate.now();
        this.lastWithdrawDate = lastInterestDate;
    }



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
        
    }


}
