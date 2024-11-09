import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, A, B;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adjList[s].add(e);
			adjList[e].add(s);
		}
		System.out.println(BFS(A, B));

	}

	private static int BFS(int from, int to) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		visited[from] = true;
		q.add(from);
		int size = 1;

		while (!q.isEmpty()) {
			for (int i = 0; i < size; i++) {
				int curr = q.poll();
				if (curr == to) {
					return cnt;
				}
				
				for (int n : adjList[curr]) {
					if (visited[n])
						continue;

					visited[n] = true;
					q.add(n);
				}
			}
			cnt += 1;
			size = q.size();

		}

		return -1;
	}
}
