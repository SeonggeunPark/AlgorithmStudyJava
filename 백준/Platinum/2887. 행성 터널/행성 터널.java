import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Position implements Comparable<Position> {
		int num, v;

		public Position(int num, int v) {
			super();
			this.num = num;
			this.v = v;
		}

		@Override
		public int compareTo(Main.Position o) {
			return this.v - o.v;
		}
	}

	public static class Edge implements Comparable<Edge> {
		int s, e, w;

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
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Position[] nx = new Position[N];
		Position[] ny = new Position[N];
		Position[] nz = new Position[N];
		int[] p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			nx[i] = new Position(i, x);
			ny[i] = new Position(i, y);
			nz[i] = new Position(i, z);
		}
		Arrays.sort(nx);
		Arrays.sort(ny);
		Arrays.sort(nz);

		Edge[] edges = new Edge[(N - 1) * 3];
		int idx = 0;
		for (int i = 0; i < N-1; i++) {
			edges[idx++] = new Edge(nx[i].num, nx[i + 1].num, nx[i + 1].v - nx[i].v);
			edges[idx++] = new Edge(ny[i].num, ny[i + 1].num, ny[i + 1].v - ny[i].v);
			edges[idx++] = new Edge(nz[i].num, nz[i + 1].num, nz[i + 1].v - nz[i].v);
		}

		Arrays.sort(edges);
		int pick = 0;
		long sum = 0;
		// x, y, z 기준 각각 배열 만들어 정렬
		for (Edge edge : edges) {
			int s = edge.s;
			int e = edge.e;
			int w = edge.w;
			
			int ps = find(s, p);
			int pe = find(e, p);
			if (ps == pe)
				continue;

			union(s, e, p);
			pick += 1;
			sum += w;
			
			if (pick>=N-1) break;
		}
		
		System.out.println(sum);
	}

	private static void union(int s, int e, int[] p) {
		p[find(s, p)] = find(e, p);
	}

	private static int find(int s, int[] p) {
		if (p[s] == s)
			return s;
		return p[s] = find(p[s], p);
	}
}
