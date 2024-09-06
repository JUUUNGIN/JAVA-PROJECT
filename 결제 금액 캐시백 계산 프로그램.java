// 과제2. 결제 금액 캐시백 계산 프로그램
// 이름:최정인
import java.util.Scanner;
public class miniTask2 {
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int cashBack = (int)(price* 0.1);
        int returnCash = 0;

        if (cashBack >=300) {
            returnCash = 300;
        } else if (cashBack >= 200) {
            returnCash = 200;
        } else if (cashBack >= 100) {
            returnCash = 100;
        } else returnCash = 0;

        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.",price,returnCash);
    }
}
