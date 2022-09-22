public class Main {
    public static void main(String[] args) {

        var control = new TextBox();
        control.enable();
        System.out.println(control.isEnabled());

//        int principle = (int) Console.readNumber("Principle: ", 100, 1_000_000);
//       float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
//       byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);
//
//       var calculator = new MortgageCalculator(principle, annualInterest, years);
//       var carCalculator = new CarLoanCalculator(principle, annualInterest, years, calculator);
//       var report = new MortgageReport(calculator, carCalculator);
//       report.printMortgage();
//       report.printPaymentSchedule();
    }

}