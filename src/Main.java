import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1, 50_000);
        double annualInterest = (double) readNumber("Interest Rate: ", 0.5, 10);
        int years = (byte) readNumber("Period (years): ", 1, 50);

        printMortage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void printMortage(int principal, double annualInterest, int years) {
        double mortage = calculateMortage(principal, annualInterest, years);
        String mortageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println();
        System.out.println("-----------MORTAGE------------");
        System.out.println("MONTHLY PAMENTS: " + mortageFormatted);
    }

    private static double calculateMortage(int principal, double annualInterest, int years) {
        double monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) + 1));
    }

    private static void printPaymentSchedule(int principal, double annualInterest, int years) {
        System.out.println();
        System.out.println("-----------PAYMENT SCHEDULE-----------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private static double calculateBalance(int principal, double annualInterest, int years) {
        double monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        double numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) + 1));
        return balance;
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
}