import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N, E, v1, v2;
	static boolean[] visited;
	static int[] dist;
	static ArrayList<Node>[] adjList;
	public static void main(String[] args) throws IOException {
		init();
		
		int distToV1 = dijkstra(1, v1);
		int distToV2 = dijkstra(1, v2);
		int v1ToV2 = dijkstra(v1, v2);
		int v1ToN = dijkstra(v1, N);
		int v2ToN = dijkstra(v2, N);
		
		int INF = Integer.MAX_VALUE;

		int path1 = (distToV1 == INF || v1ToV2 == INF || v2ToN == INF) ? INF : distToV1 + v1ToV2 + v2ToN;
		int path2 = (distToV2 == INF || v1ToV2 == INF || v1ToN == INF) ? INF : distToV2 + v1ToV2 + v1ToN;

		int result = Math.min(path1, path2);
		System.out.println(result == INF ? -1 : result);
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
	private static int dijkstra(int start, int end) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		
		// 출발점 거리 0
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		// 출발점 선택 -> 방문 안한 노드 중 dist가 가장 작은 노드
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.s == end) {
				return dist[curr.s];
			}
			
			// 인접노드 탐색 후 거리 갱신
			for (Node e : adjList[curr.s]) {
				if (visited[e.s]) continue;
				if (dist[e.s] > dist[curr.s]+e.dist) {
					dist[e.s] = dist[curr.s]+e.dist;
					pq.offer(new Node(e.s, dist[e.s]));
				}
			}
			
			visited[curr.s] = true;
		}
		
		return Integer.MAX_VALUE;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new Node(e, w));
			adjList[e].add(new Node(s, w));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		
		
	}
}
