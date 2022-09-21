import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {

        var browser = new Browser();
//        browser.navigate();

        // encapsulation in practice
//        var employee = new Employee();
//        employee.setBaseSalary(50_000);
//        employee.setHourlyRate(20);
//        employee.calculateWage(10);

//        var textBox1 = new TextBox();
//        textBox1.setText("Box 1");
//        System.out.println(textBox1.text);

        int principle = (int) readNumber("Principle: ", 100, 1_000_000);
       float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
       byte years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principle, annualInterest, years);

        printPaymentSchedule(principle, annualInterest, years);
    }

    private static void printMortgage(int principle, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principle, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.print("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principle, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principle, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextInt();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateBalance(
            int principle,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade) {

        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        double balance = principle

                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static double calculateMortgage(
            int principle,
            float annualInterest,
            byte years) {

        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;


        double mortgage = principle
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1));

        return mortgage;
    }

//    void vs returning a value ...
//    public static void greetUser(String firstName, String lastName) {
//        System.out.println("Hello " + firstName + " " + lastName);
//    }

//    public static String greetUser(String firstName, String lastName) {
//    return "Hello " + firstName + " " + lastName;
//}
}