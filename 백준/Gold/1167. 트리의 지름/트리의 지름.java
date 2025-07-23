import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int V, endNode, max, ans;
	static boolean[] visited;
	static ArrayList<Node>[] adjList;

	public static void main(String[] args) throws IOException {
		init();

		// 임의의 한 점으로 끝점 찾기
		DFS(1, 0);
		
		max = 0;
		DFS(endNode, 0);
		
		System.out.println(max);

	}
	private static void DFS(int start, int dist) {
		// 방문 체크
		visited[start] = true; 
		
		// 최대값 갱신
		if (dist > max) {
			max = dist;
			endNode = start;
		}
		
		// 인접 노드 순회
		for (Node curr : adjList[start]) {
			if (visited[curr.e]) continue;
			
			DFS(curr.e, dist+curr.w);
		}
		
		// 작업 후 원상복구
		visited[start] = false;
	}
	static class Node {
		int e;
		int w;
		public Node(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}
	}
	private static void init() throws IOException {
		V = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V+1];
		visited = new boolean[V+1];
		for (int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i=1; i<=V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			while (true) {
				int e = Integer.parseInt(st.nextToken());
				if (e==-1) break;
				adjList[v].add(new Node(e, Integer.parseInt(st.nextToken())));
			}
		}
		endNode = -1;
		ans = 0;
		max = 0;
	}
}
