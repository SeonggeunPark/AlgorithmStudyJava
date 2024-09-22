import java.util.Scanner;

/*
 * dp[0] = 1 0
 * dp[1] = 0 1
 * dp[4] = dp[3] + dp[2] =  2 3
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			int[][] dp = new int[N + 1][2];
			
			dp[0][0] = 1;
			if (N == 0) {
				System.out.println("1 0");
				continue;
			}
			dp[1][1] = 1;
			
			for (int i = 2; i <= N; i++) {
				dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
				dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
			}

			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}
}
