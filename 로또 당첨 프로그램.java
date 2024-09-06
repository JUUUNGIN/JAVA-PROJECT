//과제7. 로또 당첨 프로그램
//이름: 최정인
import java.util.*;

public class miniTask7 {

    public static int[] makeLottoNum() {
        int[] lottoArr = new int[6];
        for (int i = 0; i < 6; i++) {
            lottoArr[i] = new Random().nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (lottoArr[i] == lottoArr[j]) {
                    i--;
                }
            }
        }
        Arrays.sort(lottoArr);
        return lottoArr;
    }

    public static void printLotto(int[] lotto) {
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                System.out.printf("%02d\n", lotto[i]);
            } else {
                System.out.printf("%02d,", lotto[i]);
            }
        }
    }

    public static void printLotto(int[] lotto, int winCnt) {
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                System.out.printf("%02d => %d개 일치 \n", lotto[i], winCnt);
            } else {
                System.out.printf("%02d,", lotto[i]);
            }
        }
    }

    public static void checkLotto(int[] myARR, int[] winArr) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (myARR[i] == winArr[j]) {
                    count++;
                }
            }
        }
        printLotto(myARR,count);
    }

    public static void main(String[] args) {

        System.out.println("[로또 당첨 프로그램]");
        System.out.println();
        System.out.print("로또 개수를 입력해 주세요.(숫자 1~10):");
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        int[][] myLotto = new int[cnt][6];
        for (int i = 0; i < cnt; i++) {
            myLotto[i] = makeLottoNum();
        }

        for (int i = 0; i < cnt; i++) {
            System.out.printf("%c\t", 'A' + i);
            printLotto(myLotto[i]);
        }
        System.out.println();

        int[] winLotto = makeLottoNum();
        System.out.println("[로또 발표]");
        System.out.print("\t");
        printLotto(winLotto);

        System.out.println();

        System.out.println("[내 로또 결과]");
        for (int i = 0; i < cnt; i++) {
            System.out.printf("%c \t", 'A' + i);
            checkLotto(myLotto[i],winLotto);
        }
    }
}
