import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int n = sc.nextInt();
			int[][] stickers = new int[2][n + 1];
			int[][] dp = new int[2][n + 1];
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= n; j++) {
					stickers[i][j] = sc.nextInt();
				}
			}

			dp[0][1] = stickers[0][1];
			dp[1][1] = stickers[1][1];

			// 1. 현재 칸 스티커를 떼는 경우
			// 1-1) 이전 칸 스티커를 떼는 경우
			// 1-2) 이전 칸 스티커를 떼지 않는 경우
			// 2. 현재 칸 스티커를 뗴지 않는 경우 -> 이전 칸을 무조건 뗌
			for (int i = 2; i <= n; i++) {
				// 0행의 값 계산
				int max0 = 0;
				// 1번 경우
				max0 = Math.max(stickers[0][i] + Math.max(dp[0][i - 2], dp[1][i - 2]), stickers[0][i] + dp[1][i - 1]);
				// 2번 경우
				max0 = Math.max(max0, Math.max(dp[0][i - 1], dp[1][i - 1]));
				// 대입
				dp[0][i] = max0;

				// 1행 값 계산
				int max1 = 0;
				// 1번 경우
				max1 = Math.max(stickers[1][i] + Math.max(dp[0][i - 2], dp[1][i - 2]), stickers[1][i] + dp[0][i - 1]);
				// 2번 경우
				max1 = Math.max(max1, Math.max(dp[0][i - 1], dp[1][i - 1]));
				// 대입
				dp[1][i] = max1;
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
