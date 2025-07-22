import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N, M, ans, pick;
	static int[] p, r;
	static Edge[] edges;
	static boolean[] visited;

	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		init();

		// 가중치 작은 순으로 정렬
		Arrays.sort(edges);

		// 저렴한 간선부터 하나씩 pick
		for (int i = 0; i < M; i++) {
			Edge curr = edges[i];

			// 싸이클 체크
			if (find(curr.s) != find(curr.e)) {
				union(curr.s, curr.e);
				pick += 1;
				ans += curr.w;
			}

			// 선택한 간선 수가 (노드수-1) 이 되면 작업 종료
			if (pick >= N - 1)
				break;
		}

		System.out.println(ans);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edges = new Edge[M];
		visited = new boolean[N + 1];
		ans = 0;
		pick = 0;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(s, e, w);
		}

		// 상호배타 집합을 위한 배열
		p = new int[N + 1];
		r = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
			r[i] = 0;
		}
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (r[pa] < r[pb]) {
			p[pa] = pb;
		} else if (r[pa] > r[pb]) {
			p[pb] = pa;
		} else {
			p[pb] = pa;
			r[pa] += 1;
		}
	}

	static int find(int a) {
		if (p[a] != a) {
			return p[a] = find(p[a]);
		}
		return p[a];
	}
}
