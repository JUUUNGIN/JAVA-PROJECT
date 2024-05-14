// 과제1. 콘솔 화면에 구구단 출력하기
// 이름:최정인
public class Practice {
    public static void main(String[] args) {

        System.out.println("[구구단 출력]");

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                String st = String.format("%02d x %02d = %02d", j,i,i*j);
                System.out.print(st+"   ");
            }
            System.out.println();
        }
    }
}
