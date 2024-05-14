// 과제3. 놀이동산 입장권 계산 프로그램
// 이름:최정인
import java.util.Scanner;
public class miniTask3 {
    public static void main(String[] args) {
        System.out.println("[입장권 계산]");
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = sc.nextInt();
        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        int time = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        String merit = sc.next();
        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        String welfareCard = sc.next();

        int ticketPrice = 0;

        if (age < 3) {
            ticketPrice = 0;
        } else if (age < 13) {
            ticketPrice = 4000;
        } else if (time >= 17) {
            ticketPrice = 4000;
        } else if (merit.equals("y")) {
            ticketPrice = 8000;
        } else if (welfareCard.equals("y")) {
            ticketPrice = 8000;
        } else {
            ticketPrice = 10000;
        }

        System.out.printf("입장료: %d",ticketPrice);
    }
}
