import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principle = 0;
        byte years = 0;
        float annualInterest = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principle: ");
            principle = scanner.nextInt();
            if (principle >= 1000 && principle <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1,000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (principle >= 1 && principle <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = calculateMortgage(principle, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);

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