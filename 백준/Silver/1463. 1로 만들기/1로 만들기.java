import java.util.Scanner;

/*
 * 동적프로그래밍으로 해결 가능
 * dp[1] = 0이고,
 * dp[2] = dp[2-1]+1, dp[2/2] + 1 중 최솟값
 * 따라서, dp[N]는 dp[N-1]+1, dp[N/2]+1, dp[N/3]+1 중 최솟값이다.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		dp[1] = 0;
		for (int i=2; i<=N; i++) {
			// 최소값으로 우선 dp[i-1]+1을 대입.
			int min = dp[i-1]+1;
			// 2로 나누어 떨어지는 수일 경우 최소값 선택
			if (i%2 == 0) {
				min = Math.min(dp[i/2]+1, min);
			}
			// 3으로 나누어 떨어지는 수일 경우 최소값 선택
			if (i%3 == 0) {
				min = Math.min(dp[i/3]+1, min);
			}
			
			dp[i] = min;
		}
		
		System.out.println(dp[N]);
	}
}
