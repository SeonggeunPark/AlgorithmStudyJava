import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N, K, ans;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		init();
		
		for (int i=2; i<=K; i++) {
			dp[i][0] = 1;
			
			for (int j=1; j<=N; j++) {
				dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000000;
			}
		}
		System.out.println(dp[K][N]);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 이전 자리까지의 숫자 합이 100이면
		dp = new long[K+1][N+1];
		Arrays.fill(dp[1], 1); 
	}
}
