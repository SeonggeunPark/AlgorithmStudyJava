import java.util.Scanner;

public class Main {
	/*
	 * 동적프로그래밍으로 풀이.
	 * n개 자리의 수에서 가능한 경우의 수는
	 * n-1개 자리까지의 모든 경우의 수에 마지막 자리에 0과 1이 추가 되므로
	 * dp[n-1] * 2가 되는데, 1이 연속해서 들어가면 안되기 때문에
	 * 끝자리가 1로 끝나는 경우의 수를 빼주어야 함.
	 * 따라서,
	 * 2차원 배열로, 0번째 인덱스는 조건을 만족하는 모든 경우의 수를 저장.
	 * 1번째 인덱스는 조건을 만족하는 수 중 끝이 1로 끝나는 경우의 수를 저장.
	 * dp[n][0] = dp[n-1][0]*2 - dp[n-1][1]이 정답.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		//	0: 가능한 경우의 수, 1: 가능한 숫자 중 마지막 수가 1인 경우의 수
		long[][] dp = new long[n+1][2];
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for (int i=2; i<=n; i++) {
			dp[i][0] = dp[i-1][0]*2 - dp[i-1][1];
			dp[i][1] = dp[i-1][0] - dp[i-1][1];
		}
//		2 - 1 (1)
//		3 - 2 (1)
//		4 - 3 (2)
//		5 - 5 (2)
//		6 - 8 (2)
		
		System.out.println(dp[n][0]);
	}
}
