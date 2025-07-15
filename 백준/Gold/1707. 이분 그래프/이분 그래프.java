import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 백준 1707 : 이분 그래프 [GOLD 4]
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int K, V, E, cnt;
	static boolean[] visited, group;
	static ArrayList<Integer>[] adjList;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		out:
		for (int k=1; k<=K; k++) {
			init();
			
			for (int i=1; i<=V; i++) {
				if (visited[i]) continue;
				
				if (!BFS(i)) {
					sb.append("NO").append('\n');
					continue out;
				}
			}
			
			sb.append("YES").append('\n');
		}
		
		System.out.println(sb);
	}

	private static boolean BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			// 인접 리스트 탐색
			for (int node : adjList[curr]) {
				// 방문체크
				// (1) 방문했으면 같은 집합인지 체크
				// 	  (1-1) 다른 집합이면 PASS
				//	  (1-2) 같은 집합이면 이분 그래프 아님 => false 리턴
				if (visited[node]) {
					if (group[node] != group[curr]) {
						continue;
					} else {
						return false;
					}
				}
				// (2) 방문 안했으면 다른 집합에 배정 후 큐에 삽입
				group[node] = !group[curr];
				q.offer(node);
				visited[node] = true;
			}
		}
		
		return true;
	}

	private static void init() throws IOException {
		cnt = 1;
		StringTokenizer st  = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());	// 정점 수
		E = Integer.parseInt(st.nextToken());	// 간선 수
		
		// 방문배열, 팀배열, 인접리스트 초기화
		visited = new boolean[V+1];	// 방문했는지 확인하는 배열
		group = new boolean[V+1]; // 같은 집합인지 확인하는 배열
		adjList = new ArrayList[V+1];
		for (int i = 1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 인접리스트 입력
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adjList[s].add(e);
			adjList[e].add(s);
		}
	}
}
