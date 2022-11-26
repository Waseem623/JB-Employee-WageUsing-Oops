package org.example;

import javax.print.StreamPrintServiceFactory;

public class Employee {
    public static final int FULL_TIME_PRESENT = 1;
    public static final int PART_TIME_PRESENT = 2;
    public static final int ABSENT = 0;
    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOURS = 8;
    public static final int PART_TIME_HOURS = 4;
    public static final int MONTHLY_WORKING_DAYS = 20;
    private static final int MAX_WORKING_HOURS = 100;

    public int getMonthlyWage() {
        int totalMonthlyWage = 0;
        for (int i = 0; i < MONTHLY_WORKING_DAYS; i++) {
            int attendance = isPresent();
            int dailyWage = getDailyWage(attendance);
            totalMonthlyWage = totalMonthlyWage + dailyWage;
        }
        return totalMonthlyWage;
    }

    public int isPresent() {
        int attendance = (int) Math.floor(Math.random() * 3);
        if (attendance == FULL_TIME_PRESENT)
            return FULL_TIME_PRESENT;
        if (attendance == PART_TIME_PRESENT)
            return PART_TIME_PRESENT;
        else
            return ABSENT;
    }

    public int getDailyWage(int attendance) {
        if (attendance == FULL_TIME_PRESENT)
            return WAGE_PER_HOUR * FULL_DAY_HOURS;
        else if (attendance == PART_TIME_PRESENT)
            return WAGE_PER_HOUR * PART_TIME_HOURS;
        else
            return 0;
    }

    public int getWageForMaxDays() {
        int totalWorkingHours = 0;
        int totalWorkingDays = 0;
        int totalWage = 0;
        while (totalWorkingHours <= MAX_WORKING_HOURS && totalWorkingDays < MONTHLY_WORKING_DAYS) {
            int attendance = isPresent();
            if (attendance == FULL_TIME_PRESENT)
                totalWorkingHours += FULL_DAY_HOURS;
            if (attendance == PART_TIME_PRESENT)
                totalWorkingHours += PART_TIME_HOURS;
            totalWage = totalWage + getDailyWage(attendance);
            totalWorkingDays++;
        }
        return totalWage;
    }
}