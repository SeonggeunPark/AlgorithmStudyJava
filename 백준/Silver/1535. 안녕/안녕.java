import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] L = new int[n]; // 잃는 체력
        int[] J = new int[n]; // 얻는 기쁨

        for (int i = 0; i < n; i++) {
            L[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            J[i] = sc.nextInt();
        }

        int[] dp = new int[101]; // 체력은 최대 100까지

        for (int i = 0; i < n; i++) {
            // 역순으로 순회 (중복 사용 방지)
            for (int hp = 100; hp >= L[i] + 1; hp--) {
                dp[hp] = Math.max(dp[hp], dp[hp - L[i]] + J[i]);
            }
        }

        // 체력이 1 이상인 상태에서의 최대 기쁨 출력
        int maxJoy = 0;
        for (int hp = 1; hp <= 100; hp++) {
            maxJoy = Math.max(maxJoy, dp[hp]);
        }

        System.out.println(maxJoy);
    }
}
