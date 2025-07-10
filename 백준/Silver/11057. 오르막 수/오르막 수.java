import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int MOD = 10007;
	static long[][] dp;
	static long ans;

	public static void main(String[] args) throws IOException {
		init();
		
		// 1자리 일 땐 0~9 1개씩 가능
		for (int i=0; i<10; i++) {
			dp[1][i] = 1;
		}
		
		// 2자리부터 계산
		for (int digit=2; digit<=N; digit++) {
			// 0~9 각각 경우의 수 계산
			for (int i=0; i<10; i++) {
				// digit자리수의 맨 끝 수가 i인 경우의 수는
				// digit-1 자리수의 맨 끝 수가 0~i일 때의 모든 경우의 수를 더한 값과 같다.
				for (int j=0; j<=i; j++) {
					dp[digit][i] += dp[digit-1][j];
					dp[digit][i] %= MOD;
				}
			}
		}
		
		for (int i=0; i<10; i++) {
			ans += dp[N][i];
		}
		
		System.out.println(ans%MOD);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		dp = new long[N+1][10];
	}
}
