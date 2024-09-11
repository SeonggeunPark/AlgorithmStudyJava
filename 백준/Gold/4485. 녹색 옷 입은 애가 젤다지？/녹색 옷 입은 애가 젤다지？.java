import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int r, c;
	int w;

	public Node(int r, int c, int w) {
		this.r = r;
		this.c = c;
		this.w = w;
	}

	@Override
	public String toString() {
		return "Node [r=" + r + ", c=" + c + ", w=" + w + "]";
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}

}

public class Main {
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int p = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				return;

			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N][N];
			// 거리 배열 모두 무한대로 초기화
			dist = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					dist[r][c] = INF;
				}
			}

			dijkstra(0, 0);

			System.out.println("Problem " + p + ": " + dist[N - 1][N - 1]);
			p++;
		}
	}

	private static void dijkstra(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		dist[0][0] = map[0][0];

		pq.add(new Node(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.r][curr.c])
				continue;
			visited[curr.r][curr.c] = true;

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;

				if (dist[curr.r][curr.c] + map[nr][nc] < dist[nr][nc]) {
					dist[nr][nc] = dist[curr.r][curr.c] + map[nr][nc];
					pq.add(new Node(nr, nc, dist[nr][nc]));
				}
			}
		}
	}
}
