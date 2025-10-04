import java.io.*;
import java.util.*;


public class Main {
	static int N, M, min;
	static int[] p;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		p = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n>=2) {
				int prev=Integer.parseInt(st.nextToken());
				for (int j=2; j<=n; j++) {
					int cur = Integer.parseInt(st.nextToken());
					adjList[prev].add(cur);
					p[cur]+=1;
					prev = cur;
				}
			}
				
		}
		
		System.out.println(topologicalSort());

	}
	private static String topologicalSort() {
		StringBuilder ans = new StringBuilder();
		boolean[] visited = new boolean[N+1];
		
		// 위상정렬
		Queue<Integer> q = new ArrayDeque<Integer>();
		int pickCnt = 0;
		
		while (pickCnt < N) {
			// 1. 부모 노드가 없는 노드를 큐에 삽입
			for (int i=1; i<=N; i++) {
				if (p[i]!=0 || visited[i]) continue;
				ans.append(i).append('\n');
				pickCnt+=1;
				visited[i] = true;
				q.offer(i);
			}
			
			// 사이클 체크
			if (q.isEmpty()) {
				return "0";
			}
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				
				for (int e:adjList[cur]) {
					p[e]-=1;
				}
			}
		}
		
		return ans.toString();
	}
}