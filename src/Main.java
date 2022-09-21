import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principle = (int) readNumber("Principle: ", 100, 1_000_000);
       float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
       byte years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principle, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);

    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print("Principle: ");
            value = scanner.nextInt();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(
            int principle,
            float annualInterest,
            byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;


        double mortgage = principle
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1));

        return mortgage;
    }

//    public static void greetUser(String firstName, String lastName) {
//        System.out.println("Hello " + firstName + " " + lastName);
//    }

//    public static String greetUser(String firstName, String lastName) {
//    return "Hello " + firstName + " " + lastName;
//}
}