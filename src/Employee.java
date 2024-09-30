public class Employee {
    private int baseSalary;
    private int extraHour;
    private int hourlyRate;
    private static int numberOfEmployees;
    Employee(int baseSalary, int extraHour, int hourlyRate){
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        setExtraHour(extraHour);
        numberOfEmployees++;
    }

    Employee(int baseSalary, int extraHour){
        this(baseSalary, extraHour, 0);
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public int calculateWage(){
        return getBaseSalary() + (getExtraHour() * getHourlyRate());
    }

    private void setBaseSalary(int baseSalary){
        if (baseSalary <= 0){
            throw new IllegalArgumentException("Base salary can't be 0 or less");
        }
        this.baseSalary = baseSalary;
    }

    private void setExtraHour(int extraHour){
        if (extraHour < 0){
            throw new IllegalArgumentException("Invalid extraHour");
        }
        this.extraHour = extraHour;
    }

    private void setHourlyRate(int hourlyRate){
        this.hourlyRate = hourlyRate;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public int getExtraHour() {
        return extraHour;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }
}
