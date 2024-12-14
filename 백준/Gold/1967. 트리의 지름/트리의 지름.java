import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * 지름의 양 끝은 오직 1개의 간선만 연결되어 있을 것.
 * 인접노드가 1개뿐인 노드만 찾아 탐색.
 */


public class Main {
	public static class Edge{
		int e;
		int w;
		public Edge() {
		}
		public Edge(int e, int w) {
			this.e = e;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Edge [e=" + e + ", w=" + w + "]";
		}
	}
	static int n, maxD;
	static List<Edge>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		// 인접리스트 초기화
		adjList = new ArrayList[n+1];
		for (int i=1 ;i<=n; i++) {
			adjList[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];	// 방문배열 초기화

		// 간선 입력받아 인접리스트에 기록
		for (int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken()); // 노드1
			int node2 = Integer.parseInt(st.nextToken()); // 노드2
			int w = Integer.parseInt(st.nextToken());	// 가중치
			 // 두 노드에 각각 기록
			adjList[node1].add(new Edge(node2, w)); 
			adjList[node2].add(new Edge(node1, w)); 
		}
		
		maxD = 0;	// 최대 지름 초기화
		
		// 연결된 간선이 1개인 노드만 찾아 DFS 탐색
		for (int i=1; i<=n; i++) {
			if (adjList[i].size() != 1) continue;
			Arrays.fill(visited, false); // 방문배열 초기화
			visited[i] = true;
			DFS(i, 0);
		}
		
		System.out.println(maxD);
	}
	private static void DFS(int node, int diameter) {
//		System.out.println(node+" 방문");
		// 인접한 노드 방문
		for (Edge edge : adjList[node]) {
			if (visited[edge.e]) continue;
			visited[edge.e] = true;
			DFS(edge.e, diameter+edge.w);
		}
		// 최대지름 갱신
		if (maxD < diameter) {
			maxD = diameter;
		}
	}
}
