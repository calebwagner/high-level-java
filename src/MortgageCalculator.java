public class MortgageCalculator {
    /**
     * MortgageCalculator fields
     */
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private int principle;
    private float annualInterest;
    private byte years;

    /**
     * MortgageCalculator constructor
     */
    public MortgageCalculator(int principle, float annualInterest, byte years) {
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    /**
     * MortgageCalculator methods
     */
    public double calculateBalance(short numberOfPaymentsMade) {
        // getter method below
        short numberOfPayments = getNumberOfPayments();
        // getter method below
        float monthlyInterest = getMonthlyInterest();
        // principle declared above & same with monthlyInterest, numberOfPayments
        // numberOfPaymentsMade is parameter
        double balance = principle
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        // exit calculateBalance with balance
        return balance;
    }

    public double calculateMortgage() {
        // getter method below
        short numberOfPayments = getNumberOfPayments();
        // getter method below
        float monthlyInterest = getMonthlyInterest();
        // principle declared above & same with monthlyInterest, numberOfPayments
        double mortgage = principle
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        // exit calculateMortgage with mortgage
        return mortgage;
    }

    /**
     * MortgageCalculator getters
     */
    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        };
        return balances;
    }

    // MortgageCalculator getter
    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    // MortgageCalculator getter
    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }
}
