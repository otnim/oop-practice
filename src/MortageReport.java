import java.text.NumberFormat;

public class MortageReport {
    private final NumberFormat currencyInstance;
    private MortageCalculator mortageCalculator;

    public MortageReport(MortageCalculator mortageCalculator) {
        this.mortageCalculator = mortageCalculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("-----------PAYMENT SCHEDULE-----------");

        for (double balance : mortageCalculator.getRemainingBalances()) {
            System.out.println(currencyInstance.format(balance));
        }
    }

    public void printMortage() {
        double mortage = mortageCalculator.calculateMortage();
        String mortageFormatted = currencyInstance.format(mortage);
        System.out.println();
        System.out.println("-----------MORTAGE------------");
        System.out.println("MONTHLY PAMENTS: " + mortageFormatted);
    }
}
