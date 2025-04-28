import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans, N, S;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = 0;
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		
		if (S==0) ans -= 1;
		
		System.out.println(ans);
	}
	private static void DFS(int sum, int idx) {
		if (idx >= N) {
			if (sum == S) {
				ans += 1;
			}
			return;
		}
		
		// 더한다
		DFS(sum + arr[idx], idx+1);
		// 안더한다
		DFS(sum, idx+1);
	}
}