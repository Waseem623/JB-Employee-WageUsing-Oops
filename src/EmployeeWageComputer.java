package org.example;

public class EmployeeWageComputer {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computer");
        int monthlyWage = 0;
        int totalWage = 0;
        Employee empObj = new Employee();
        monthlyWage = empObj.getMonthlyWage();
        System.out.println("Total monthly wage = " + monthlyWage);
        totalWage = empObj.getWageForMaxDays();
        System.out.println("Total wage till max condition fullfills : " + totalWage);
    }
}