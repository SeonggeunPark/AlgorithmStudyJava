import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, K, cnt, ans;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		init();

		out:
		for (int i = 2; i <= N; i++) {
			if (visited[i])
				continue;
			
			visited[i] = true;
			cnt += 1;
			
			if (cnt >= K) {
				ans = i;
				break out;
			}
			for (int j = 2; j <= N / i; j += 1) {
				if (visited[i*j]) continue;
				visited[j * i] = true;
				cnt += 1;
				if (cnt >= K) {
					ans = j*i;
					break out;
				}
			}
		}

		System.out.println(ans);
	}

	private static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		ans = 0;
		visited = new boolean[N + 1];
	}
}
