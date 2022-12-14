import java.text.NumberFormat;

public class MortgageReport {
    /**
     * MortgageReport fields
     */
    private final NumberFormat currency;
    private MortgageCalculator calculator;

    private CarLoanCalculator carCalculator;

    /**
     * MortgageReport constructor
     */
    public MortgageReport(MortgageCalculator calculator, CarLoanCalculator carCalculator) {
        this.calculator = calculator;
        this.carCalculator = carCalculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    /**
     * MortgageReport methods
     */
    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances()) {
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.print("Monthly Payments: " + mortgageFormatted);
    }
}
