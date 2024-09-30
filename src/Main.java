import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var employee = new Employee(50_000, 20, 10);
        var employee2 = new Employee(50_000, 20);
        System.out.println(employee2.calculateWage());
        int wage = employee.calculateWage();
        System.out.println(wage);

        System.out.println("number of employees = " + Employee.getNumberOfEmployees());
    }
}