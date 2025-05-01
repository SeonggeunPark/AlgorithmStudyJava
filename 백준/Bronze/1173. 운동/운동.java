import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 운동 시간
        int m = sc.nextInt(); // 최소 심박수
        int M = sc.nextInt(); // 최대 심박수
        int T = sc.nextInt(); // 운동 시 증가 심박수
        int R = sc.nextInt(); // 휴식 시 감소 심박수

        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        int pulse = m;
        int total = 0;

        while (time < N) {
            if (pulse + T <= M) {
                pulse += T;
                time++;
            } else {
                pulse = Math.max(m, pulse - R);
            }
            total++;
        }

        System.out.println(total);
    }
}
