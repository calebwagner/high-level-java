public class CarLoanCalculator {
    private final static byte MONTHS_IN_YEARS = 12;
    private final static byte PERCENT = 100;
    private float principle;
    private float annualInterest;
    private byte years;

    private MortgageCalculator calculator;

    public CarLoanCalculator(int principle, float annualInterest, byte years, MortgageCalculator calculator) {
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.years = years;
        this.calculator = calculator;
    }
}
