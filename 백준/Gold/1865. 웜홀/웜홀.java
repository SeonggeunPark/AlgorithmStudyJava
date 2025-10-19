import java.io.*;
import java.util.*;

public class Main {
	public static class Edge {
		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			Edge[] edges = new Edge[M * 2 + W];

			List<Edge>[] adjList = new List[N + 1];
			int idx = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges[idx++] = new Edge(s, e, w);
				edges[idx++] = new Edge(e, s, w);
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges[idx++] = new Edge(s, e, -w);
			}

			// 벨만-포드 알고리즘
			System.out.println(bellmanFord(edges, N) ? "YES" : "NO");
		}
	}

	private static boolean bellmanFord(Edge[] edges, int N) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, 0);

		// 모든 간선을 순회 => N-1번 반복
		// Why? 한 지점에서 다른 지점으로 갈 때 최소 거리는 사이클이 있지 않은 한, 최대 N-1개의 간선을 쓰기 때문
		for (int i = 0; i < N - 1; i++) {
			boolean updated = false;
			for (Edge e : edges) {
				if (dist[e.s] + e.w < dist[e.e]) {
					dist[e.e] = dist[e.s] + e.w;
					updated = true;
				}
			}
			if (!updated)
				break;
		}

		for (Edge e : edges) {
			if (dist[e.s] + e.w < dist[e.e]) {
				return true;
			}
		}

		return false;
	}
}
