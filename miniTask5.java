//과제5.달력 출력 프로그램
//이름: 최정인

import java.time.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");
        Scanner sc = new Scanner(System.in);

        System.out.print("달력의 년도를 입력해주세요.(yyyy):");
        int year = readYear(sc);

        System.out.print("달력의 월을 입력해주세요.(mm):");
        int month = readMonth(sc);

        List<YearMonth> yearMonths = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            YearMonth yearMonth = YearMonth.of(year, month).plusMonths(i);
            yearMonths.add(yearMonth);
        }

        printCalendars(yearMonths);
    }

    private static int readYear(Scanner sc) {
        int year;
        while (true) {
            try {
                year = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("잘못된 입력입니다. 달력의 년도를 입력해주세요.(yyyy):");
                sc.next(); // clear the invalid input
            }
        }
        return year;
    }

    private static int readMonth(Scanner sc) {
        String monthStr;
        while (true) {
            monthStr = sc.nextLine();
            if (isValidMonth(monthStr)) {
                return Integer.parseInt(monthStr);
            } else {
                System.out.print("잘못된 입력입니다. 달력의 월을 입력해주세요.(mm):");
            }
        }
    }

    private static boolean isValidMonth(String input) {
        String regex = "^(0[1-9]|1[0-2])$";
        return input.matches(regex);
    }

    private static void printCalendars(List<YearMonth> yearMonths) {
        // Print the headers
        for (YearMonth yearMonth : yearMonths) {
            System.out.printf("[%d년 %02d월]                    ", yearMonth.getYear(), yearMonth.getMonthValue());
        }
        System.out.println();

        // Print the days of the week
        for (int i = 0; i < yearMonths.size(); i++) {
            System.out.print("일\t월\t화\t수\t목\t금\t토       ");
        }
        System.out.println();

        // Print the calendar days
        for (int week = 0; week < 6; week++) {
            for (YearMonth yearMonth : yearMonths) {
                LocalDate startDate = yearMonth.atDay(1);
                LocalDate endDate = yearMonth.atEndOfMonth();
                int dayOfWeekValue = startDate.getDayOfWeek().getValue() % 7; // Sunday as 0

                for (int day = 0; day < 7; day++) {
                    int currentDay = week * 7 + day - dayOfWeekValue + 1;
                    if (currentDay > 0 && currentDay <= endDate.getDayOfMonth()) {
                        System.out.printf("%02d\t", currentDay);
                    } else {
                        System.out.print("    ");
                    }
                }
                System.out.print("    ");
            }
            System.out.println();
        }
    }
}
