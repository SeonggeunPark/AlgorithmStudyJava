import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N이 홀수일 땐 전체 칸 수가 홀수이므로, 2*1, 1*2 타일로는 모두 채울 수 없음. 따라서 항상 0
 * 
 * dp[n] = dp[n-2]*3 + dp[n-4]*2 + dp[n-6]*2 + ..... + dp[2]*2
 * dp[n-2] = dp[n-4]*3 + dp[n-6]*2 + .... dp[2]*2
 * 
 * dp[n]-dp[n-2] = dp[n-2]*3 - dp[n-4]
 * dp[n] = dp[n-2]*4 - dp[n-4]
 * 
 * 따라서, dp[n] = dp[n-2]*4 - dp[n-4]
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static int N;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		init();
		
		if (N%2 != 0) {
			System.out.println(0);
		}
		else {
			dp[0] = 1;
			dp[2] = 3;
			for (int i=4; i<=N; i+=2) {
				dp[i] = dp[i-2]*4 - dp[i-4];
			}
			
			System.out.println(dp[N]);
		}
		
	}

	private static void init() throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new long[N+1];
		

	}
}
