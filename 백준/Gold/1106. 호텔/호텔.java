import java.io.*;
import java.util.*;

public class Main {
	static int C, N, ans;
	static int[] dp;
	static int[][] cities;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dp = new int[C+101];
		// 도시 정보 입력
		cities = new int[N][2];
		for (int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			cities[i][0] = Integer.parseInt(st.nextToken());
			cities[i][1] = Integer.parseInt(st.nextToken());
		}
		
		ans = INF;
		// dp 입력
		for (int i=1; i<=C+100; i++) {
			dp[i] = INF;
			for (int[] city : cities) {
				int cost = city[0];
				int customer = city[1];
				if (i-customer>=0 && dp[i-customer]!=INF) {
					dp[i] = Math.min(dp[i-customer]+cost, dp[i]);
				}
			}
			
			if (i>=C) {
				ans = Math.min(dp[i], ans);
			}
		}
		
		System.out.println(ans);
	}
}
