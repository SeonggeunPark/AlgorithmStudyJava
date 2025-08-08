import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static long[] dp;
	static int[] inputs;

	public static void main(String[] args) throws IOException {
		init();

		int T = Integer.parseInt(br.readLine());
		int max = 0;
		inputs = new int[T];
		for (int t=0; t<T; t++) {
			inputs[t] = Integer.parseInt(br.readLine());
			max = Math.max(max, inputs[t]);
		}
		dp = new long[max+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i=4; i<=max; i++) {
			dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
			dp[i] %= 1000000009;
		}
		
		for (int n : inputs) {
			sb.append(dp[n]).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void init() throws IOException {
	}
}
