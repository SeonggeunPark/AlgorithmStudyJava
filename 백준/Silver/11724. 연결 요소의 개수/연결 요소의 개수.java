import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] adjList;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 인접행렬 생성 (1부터 N까지의 노드)
		adjList = new int[N+1][N+1];
		// 인접행렬 작성
		for (int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adjList[u][v] = 1;
			adjList[v][u] = 1;
		}
		
		visited = new boolean[N+1];
		int cnt = 0;
		
		for (int i=1 ; i<=N; i++) {
			// 이미 방문했다면 패스
			if (visited[i]) continue;
			DFS(i);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	private static void DFS(int v) {
		visited[v] = true;
		// 인접행렬 뒤져서 연결되어있는 노드 방문
		for (int i=1; i<=N; i++) {
			if (adjList[v][i]==1 && !visited[i]) {
				DFS(i);
			}
		}
	}
}
