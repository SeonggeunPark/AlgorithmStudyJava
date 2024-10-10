import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] adjList;
	static boolean[] visited;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 노드 개수
		M = sc.nextInt(); // 간선 개수
		// 인접 행렬 작성
		adjList = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			adjList[s][e] = 1;
			adjList[e][s] = 1;
		}

		// 각 노드를 시작점으로 다익스트라를 돌려 케빈케이컨 수를 구함
		int minNode = 0;
		int min = INF;
		for (int i = 1; i <= N; i++) {
			int tmp = dijkstra(i);
			
			if (min > tmp) {
				minNode = i;
				min = tmp;
			}
		}
		
		System.out.println(minNode);
	}

	private static int dijkstra(int start) {
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
		dist[start] = 0; // 시작점은 거리 0으로.
		
		visited[start] = true; // 해당 노드 선택
		
		for (int i=1; i<=N; i++) {
			if (adjList[start][i] == 1) {
				dist[i] = 1;
			}
		}
		
		for (int cnt = 1; cnt <= M; cnt++) {
			// 노드 선택
			int v = 0;
			int min = INF;
			// 그다음 노드 정하기
			for (int i = 1; i <= N; i++) {
				if (dist[i]<min && !visited[i]) {
					min = dist[i];
					v = i;
				}
			}
			
			visited[v] = true;	// 노드 선택
			
			for (int i=1; i<=N; i++) {
				if (adjList[v][i]==1 && !visited[i] && dist[i]>dist[v]+1) {
					dist[i] = dist[v]+1;
				}
			}
		}
		int sum = 0;
		for (int i=1; i<=N; i++) {
			sum += dist[i];
		}
		return sum;
	}
}