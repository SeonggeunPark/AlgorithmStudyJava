import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node> {
		int v, w;

		public Node() {
		}

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	static ArrayList<Node>[] adjList;
	static boolean[] visited;
	static int[] dist;
	static int V, E;
	static int start;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		init();
		dijkstra(start);
		print();
	}

	private static void print() {
		for (int i = 1; i <= V; i++) {
			if (dist[i] < INF) {
				System.out.println(dist[i]);
			} else {
				System.out.println("INF");
			}
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// dist배열 초기화
		dist = new int[V + 1];
		Arrays.fill(dist, INF);

		dist[start] = 0; // 시작 정점 지정
		// 큐에 시작점 삽입(가중치는 0)
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.v])
				continue;
			visited[cur.v] = true;

			// 인접행렬 탐색
			for (Node node : adjList[cur.v]) {
				if (visited[node.v])
					continue;

				if (dist[node.v] > cur.w + node.w) {
					dist[node.v] = dist[cur.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
	}

	static void init() {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // 정점의 수
		E = sc.nextInt(); // 간선의 수
		start = sc.nextInt(); // 시작 정점 번호
		// 인접행렬 입력
		adjList = new ArrayList[V + 1]; // 정점번호 1부터 시작
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		// 방문배열 초기화
		visited = new boolean[V + 1];
	}

}
