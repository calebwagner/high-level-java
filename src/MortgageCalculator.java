public class MortgageCalculator {
    private int principle;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principle, float annualInterest, byte years) {
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        short numberOfPayments = (short) (years * Main.MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        double balance = principle
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {

        short numberOfPayments = (short) (years * Main.MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;


        double mortgage = principle
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        return mortgage;
    }

    public short getYears() {
        return years;
    }
}
