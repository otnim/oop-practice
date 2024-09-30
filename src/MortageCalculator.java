import java.text.NumberFormat;

public class MortageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private  double annualInterest;
    private byte years;

    MortageCalculator(int principal, double annualInterest, byte years) {
        this.annualInterest = annualInterest;
        this.years = years;
        this.principal = principal;
    }

    public double calculateMortage() {
        double monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) + 1));
    }

    public double calculateBalance(short month) {
        double monthlyInterest = getMonthlyInterest();
        double numberOfPayments = getNumberOfPayments();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) + 1));
        return balance;
    }

    public double[] getRemainingBalances(){
        double[] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= getNumberOfPayments(); month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private double getMonthlyInterest() {
        return annualInterest / MONTHS_IN_YEAR / PERCENT;
    }
}
