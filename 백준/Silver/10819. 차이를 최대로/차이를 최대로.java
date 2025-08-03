import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		init();
		for (int i=0; i<N; i++) {
			visited[i] = true;
			dfs(1, i, 0);
			visited[i] = false;
		}
		
		
		System.out.println(ans);
	}

	private static void dfs(int pick, int idx, int sum) {
		if (pick >= N) {
			ans = Math.max(ans, sum);
		}
		for (int i=0; i<N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			dfs(pick + 1, i, sum + (Math.abs(arr[idx]-arr[i])));
			visited[i] = false;
		}
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		ans = 0;
		arr = new int[N];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
