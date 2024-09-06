//과제6.가상 선거 및 당선 시뮬레이션 프로그램
//이름: 최정인

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class miniTask6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("총 진행할 투표수를 입력해 주세요.");
        int votes = sc.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        int candidate = sc.nextInt();
        sc.nextLine();

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < candidate; i++) {
            System.out.printf("%d번째 후보자 이름을 입력해 주세요.", (i+1));
            String name = sc.nextLine();
            arr.add(name);
        }
        Random random = new Random();
        int num = 0;

        int[] sum = new int[candidate];//투표결과 저장 배열
        Arrays.fill(sum, 0); //배열 0으로 초기화

        for (int i = 0; i < votes; i++) {
            double rate = (double) (i + 1) / votes * 100;

            num = random.nextInt(candidate)+1; //1부터 후보자 인원까지 임의번호 생성

            System.out.printf("[투표진행률]: %.2f%%, %d명 투표 => %s\n", rate, (i + 1), arr.get(num-1));
            sum[num-1]++;

            for (int j = 0; j < candidate; j++) {
                double personRate = (double) sum[j] / votes * 100;
                System.out.printf("[기호:%d] %s:", (j+1), arr.get(j));

                if (arr.get(j).length() < 2) { //출력화면 간격 유지
                    System.out.print("\t\t");
                } else if (arr.get(j).length() < 4) {
                    System.out.print("\t");
                }
                System.out.printf("%.2f%% \t (투표수: %d)\n",personRate,sum[j]);
            }
            System.out.println();
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < sum.length; i++) {
            if (max < sum[i]) { //최대 투표를 받는 사람을 찾는 조건
                max = sum[i];
                maxIndex = i;
            }
        }
        System.out.println("[투표결과] 당선인 : " + arr.get(maxIndex));
    }
}
