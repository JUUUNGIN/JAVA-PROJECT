// 과제4. 주민등록번호 생성 프로그램
// 이름:최정인
import java.util.Random;
import java.util.Scanner;
public class miniTask4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        String year = sc.next();
        System.out.print("출생월을 입력해 주세요.(mm):");
        String month = sc.next();
        System.out.print("출생일을 입력해 주세요.(dd):");
        String day = sc.next();
        System.out.print("성별을 입력해 주세요.(m/f):");
        String sex = sc.next();

        StringBuffer number = new StringBuffer();
        number.append(year.substring(2) + month + day + "-");
        if (sex.equals("m")) {
            number.append("3");
        } else if (sex.equals("f")) {
            number.append("4");
        }

        String backNumber = String.format("%06d", random.nextInt(999999) + 1);
        number.append(backNumber);

        System.out.println(number);
    }
}
