//과제8.과세금액 계산 프로그램
//이름: 최정인

import java.util.*;

public class miniTask8 {

    public static int[] standard = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000, 0};
    public static int[] rate = {6, 15, 24, 35, 38, 40, 42, 45};
    public static int[] differance = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};
    public static int[] standardCal = {12000000, 34000000, 42000000, 62000000, 150000000, 200000000, 500000000, 0};

// 세율따라 세금 구하기 파트
    public static void calculateTax(int income) {
        int tmp = income;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; tmp > 0 ; i++) {
            if (tmp > standardCal[i]) {
                list.add(standardCal[i]);
                tmp -= standardCal[i];
            } else {
                list.add(tmp);
                tmp = 0;
            }
        }
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            int answer = list.get(i) * rate[i]/100;
            sum += answer;
            System.out.printf("%10d * %3d%% = \t%10d\n", list.get(i), rate[i], answer);
        }
        System.out.printf("[세율에 의한 세금]: \t\t\t%10d\n", sum);
    }
// 누진공제 금액 구하기 파트
    public static void accumulateTax(int income) {
        int result = 0;

        for (int i = 0; i < standard.length; i++) {
            if (income <= standard[i]) {
                result = income * rate[i]/100 - differance[i];
                break;
            } else if (income > 1000000000) {
                result = income *rate[7]/100 - differance[7];
                break;
            }
        }
        System.out.printf("[누진공제 계산에 의한 세금]: \t%10d\n", result);
    }
  
    public static void main(String[] args) {

        System.out.println("[과세금액 계산 프로그램]");
        System.out.println("연소득을 입력해 주세요.:");
        Scanner sc = new Scanner(System.in);
        int income = sc.nextInt();

        calculateTax(income);
        accumulateTax(income);
    }
}
