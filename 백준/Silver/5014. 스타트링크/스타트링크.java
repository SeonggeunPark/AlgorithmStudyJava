import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F, S, G, U, D;
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		ans = Integer.MAX_VALUE;
		visited = new boolean[F + 1];
		// S층에서 시작
//		dfs(0, S);
		int ans = bfs(S);

		if (ans == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
	}

	static int bfs(int floor) {
		Queue<Integer> q = new LinkedList<>();
		
		visited[floor] = true;
		int cnt = 0;
		int size = 1;
		q.add(S);
		while(!q.isEmpty()) {
			for (int i=0; i<size; i++) {
				int popItem = q.poll();
				if (popItem == G) return cnt;
				if (popItem+U <= F && !visited[popItem+U]) {
					visited[popItem+U] = true;
					q.add(popItem+U);
				}
				if (popItem-D >= 1 && !visited[popItem-D]) {
					visited[popItem-D] = true;
					q.add(popItem-D);
				}
			}
			
			size = q.size();
			cnt++;
		}
		
		return -1;
	}
}
