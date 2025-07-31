import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N, M, K, X;
	static boolean[] visited;
	static int[] dist;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		init();
		
		dijkstra(X);
		
		for (int i=1; i<=N; i++) {
			if (dist[i] != K) continue;
			sb.append(i).append('\n');
		}
		
		System.out.println(sb.length()>0 ? sb : -1);
	}
	static class Node implements Comparable<Node>{
		int s;
		int dist;
		public Node(int s, int dist) {
			super();
			this.s = s;
			this.dist = dist;
		}
		@Override
		public int compareTo(Main.Node o) {
			return this.dist - o.dist;
		}
	}
	private static void dijkstra(int start) {
		// 출발점 거리 0
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		// 출발점 선택 -> 방문 안한 노드 중 dist가 가장 작은 노드
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			// 인접노드 탐색 후 거리 갱신
			for (int e : adjList[curr.s]) {
				if (visited[e]) continue;
				if (dist[e] > 1+curr.dist) {
					dist[e] = 1+curr.dist;
					pq.offer(new Node(e, dist[e]));
				}
			}
			
			visited[curr.s] = true;
		}
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		adjList = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adjList[s].add(e);
		}
	}
}
