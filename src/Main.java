//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1, 50_000);
        double annualInterest = Console.readNumber("Interest Rate: ", 0.5, 10);
        byte years = (byte) Console.readNumber("Period (years): ", 1, 50);

        MortageCalculator mortageCalculator = new MortageCalculator(principal, annualInterest, years);
        MortageReport mortageReport = new MortageReport(mortageCalculator);
        mortageReport.printMortage();
        mortageReport.printPaymentSchedule();
    }
}