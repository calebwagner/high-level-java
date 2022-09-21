public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {

        int principle = (int) Console.readNumber("Principle: ", 100, 1_000_000);
       float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
       byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

       var calculator = new MortgageCalculator(principle, annualInterest, years);
       var report = new MortgageReport(calculator);
       report.printMortgage();
       report.printPaymentSchedule();
    }

}