import java.util.Scanner;

/*
 *  동적프로그래밍 문제. 길이가 2*n인 타일은
 *  (1) 길이가 n-2인 타일에서 길이 2짜리 타일을 붙이는 경우
 *  (2) 길이가 n-1인 타일에서 길이 1짜리 타일을 붙이는 경우
 *  2가지 경우를 합친 것과 같다.
 *  
 *  여기서 길이가 2인 타일을 붙이는 경우에서 세로막대 2개(|||)
 *  가 붙은 경우 길이 1짜리 타일을 붙이는 경우와 중복되는 경우가 있으므로
 *  해당 중복을 제외해준다.
 *  
 *  따라서
 *  dp[N] = dp[N-2] * dp[2] + dp[N-1] * dp[1] - dp[N-2]
 *  	  = 2*dp[N-2] + dp[N-1]
 */

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] dp = new long[N+1];
		// N이 1일 땐 1을 출력하고 종료
		if (N==1) {
			System.out.println(1);
			return;
		}
		// 길이 1일 때와 2일 때를 미리 저장
		dp[1] = 1;
		dp[2] = 3;
		// 길이 3부터 계산
		for (int i=3; i<=N; i++) {
			dp[i] = (dp[i-2]*2 + dp[i-1]);
			dp[i] = dp[i]%10007;
		}
		
		System.out.println(dp[N]);
	}
}
