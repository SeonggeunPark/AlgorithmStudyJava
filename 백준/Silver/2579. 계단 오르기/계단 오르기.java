import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 계단 수
		// 계단별 점수 저장할 배열
		int[] stairs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = sc.nextInt();
		}
		if (N == 1) {
			System.out.println(stairs[1]);
			return;
		}
		// 동적프로그래밍 배열
		int[] dp = new int[N + 1];

		dp[0] = 0;
		dp[1] = stairs[1];
		dp[2] = stairs[1] + stairs[2];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(stairs[i] + stairs[i - 1] + dp[i - 3], stairs[i] + dp[i - 2]);
		}

		System.out.println(dp[N]);
	}

}
