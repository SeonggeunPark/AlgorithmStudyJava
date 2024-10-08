import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];
		// 배열 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = arr[0][0];
		// dp 배열 입력
		// 이전 행의 dp값 중 더 큰 값을 선택하여 더함
		for (int i = 1; i < N; i++) {
			dp[i][0] = arr[i][0] + dp[i-1][0];
			dp[i][i] = arr[i][i] + dp[i-1][i-1];
			for (int j = 1; j < i; j++) {
				dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
			}
		}
		int ans =0;
		// 마지막 행의 최대값을 선택
		for (int i=0; i<N; i++) {
			ans = Math.max(dp[N-1][i], ans);
		}
		System.out.println(ans);
		
	}
}
