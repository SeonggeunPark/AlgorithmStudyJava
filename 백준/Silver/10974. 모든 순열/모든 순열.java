import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static int[] pick;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		init();
		
		permutate(1);
		
		System.out.println(sb);
	}
	
	private static void permutate(int idx) {
		if (idx > N) {
			for (int i=1; i<=N; i++) {
				sb.append(pick[i]).append(' ');
			}
			sb.append('\n');
		}
		for (int i=1; i<=N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			pick[idx] = i;
			permutate(idx+1);
			visited[i] = false;
		}
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		pick = new int[N+1];
		ans = 0;
	}
}
