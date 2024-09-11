import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[Math.max(N, M)*2+1];
		cnt = 0;
		BFS(N);
		
		System.out.println(cnt);
	}
	static int cnt;
	
	static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		
		int size = q.size();
		
		while (!q.isEmpty()) {
//			System.out.println(q);
			for (int i = 0; i < size; i++) {
				int popItem = q.poll();
				if (popItem == M)
					return;

				if (popItem+1 < visited.length && !visited[popItem + 1]) {
					q.add(popItem + 1);
					visited[popItem+1] = true;
				}
				if (popItem-1 >= 0 && !visited[popItem - 1]) {
					q.add(popItem - 1);
					visited[popItem-1] = true;
				}
				if (popItem*2 < visited.length && !visited[popItem * 2]) {
					q.add(popItem * 2);
					visited[popItem*2] = true;
				}
			}
			cnt ++;
			size = q.size();
		}
	}
}
