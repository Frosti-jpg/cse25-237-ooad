package BankingSystem;

public class AdditionalIncomeSources {
    
    private String sourceOfIncome;

    public AdditionalIncomeSources() {
        sourceOfIncome = "";
    }

    public AdditionalIncomeSources(String sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }

    //setters

    public void setSourceOfIncome(String sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }


    //getters

    public String getSourceOfIncome() {
        return sourceOfIncome;
    }
}
