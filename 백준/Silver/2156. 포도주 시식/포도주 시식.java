import java.util.Scanner;

/*
 * 현재까지 마신 양의 최대값을 선택
 *  (1) 현재 잔을 마시는 경우
 *  	(1)-1. 이전 잔을 마신 경우
 *  		=> dp[n] = dp[n-3] + wine[n-1] + wine[n]
 *  	(1)-2. 이전 잔을 마시지 않은 경우
 *  		=> dp[n] = dp[n-2] + wine[n]
 * 	(2) 현재 잔을 마시지 않는 경우
 * 			=> dp[n] = dp[n-1]
 */
public class Main {
	static int n;
	static int[] wine;
	static int[] dp;

	public static void main(String[] args) {

		input(); // 입력

		dynamicProgramming();

		print();
	}
	
	// 출력하는 메서드
	private static void print() {
		System.out.println(dp[n]);
	}
	
	// dp 시작
	private static void dynamicProgramming() {
		dp[1] = wine[1];

		for (int i = 2; i <= n; i++) {
			// 현재 잔을 마시지 않는 경우
			int max = dp[i - 1];
			// dp[2] or dp[3] 넣기
			if (i <= 3) {
				dp[i] = Math.max(max, wine[i - 1] + wine[i]);
				dp[i] = Math.max(dp[i], dp[i - 2] + wine[i]);
				continue;
			}

			// (1)-1. 현재잔을 마시고, 이전 잔을 마신 경우
			max = Math.max(max, dp[i - 3] + wine[i - 1] + wine[i]);
			// (1)-2. 현재잔을 마시고, 이전 잔을 마시지 않은 경우
			max = Math.max(max, dp[i - 2] + wine[i]);

			dp[i] = max;
		}
	}

	// 입력 받는 메서드
	private static void input() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 포도잔 개수
		wine = new int[n + 1];
		dp = new int[n + 1];
		
		for (int i=1; i<=n; i++) {
			wine[i] = sc.nextInt();
		}
	}
}
