import java.io.*;
import java.util.*;

/*
 * 현재 자리가 i으로 끝나는 경우의수 =
 * 이전 자리가 i-1로 끝나는 모든 경우의수 + 이전 자리가 i+1로 끝나는 모든 경우의수
 * 
 * N=9까지는 무조건 0개
 * 이전 자리랑 1 차이나면서,0~9가 모두 있는지까지 체크 
 */
public class Main {
	static int N;
	static long[][][] dp;
	static final int DIVISOR = 1_000_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1][10][(int) Math.pow(2, 10)];

		// 0으로 시작하는 경우 빼고 1의자리 세팅
		for (int j = 1; j <= 9; j++) {
			dp[1][j][1 << j] = 1;
		}
		// 2자리 수부터 시작
		for (int digit = 2; digit <= N; digit++) {
			for (int i = 0; i <= 9; i++) {
				for (int j = 1; j <= 1023; j++) {
					if (i > 0) {
						dp[digit][i][j | (1 << i)] += dp[digit - 1][i - 1][j];
					}
					if (i < 9) {
						dp[digit][i][j | (1 << i)] += dp[digit - 1][i + 1][j];
					}
					dp[digit][i][j] %= DIVISOR;
				}
			}
		}
		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += dp[N][i][1023];
			ans %= DIVISOR;
		}

		System.out.println(ans);
	}
}
