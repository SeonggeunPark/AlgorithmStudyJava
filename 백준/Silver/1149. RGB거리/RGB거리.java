import java.util.Scanner;
/*
 * n번째 집을 칠하는 경우의 최소 비용
 * (1) n번째의 색을 R로 칠하는 경우 => Math.min(n-1번째를 G로 칠하는 경우의 최소값, n-1번째를 B로 칠하는 경우의 최소값)
 * (2) n번째의 색을 G로 칠하는 경우 => Math.min(n-1번째를 R로 칠하는 경우의 최소값, n-1번째를 B로 칠하는 경우의 최소값)
 * (3) n번째의 색을 B로 칠하는 경우 => Math.min(n-1번째를 R로 칠하는 경우의 최소값, n-1번째를 G로 칠하는 경우의 최소값)
 *  (1), (2), (3) 중 최소값이 최소비용임
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] cost = new int[N][3];
		int[][] dp = new int[N][3];
		for (int i=0; i<N; i++) {
			cost[i][0] = sc.nextInt();
			cost[i][1] = sc.nextInt();
			cost[i][2] = sc.nextInt();
		}
		int ans = 0;
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];

		for (int i=1; i<N; i++) {
			dp[i][0] = cost[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2]+Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		ans = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
		System.out.println(ans);
	}
}
