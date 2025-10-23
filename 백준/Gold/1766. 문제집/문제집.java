import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degrees = new int[N+1];
        List<Integer>[] adjList = new List[N+1];
        for (int i=1; i<=N; i++) {
        	adjList[i] = new ArrayList<>();
        }
        
        for (int i=1; i<=M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	adjList[s].add(e);
        	degrees[e]+=1;
        }
        
        StringBuilder sb = new StringBuilder();
        // degree가 0인 것을 1번부터 큐에 삽입
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i=1;i<=N;i++) {
        	if(degrees[i]<=0)
        		q.offer(i);
        }
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	sb.append(cur).append(' ');
        	
        	// 인접노드 탐색
        	for (int i=0; i<adjList[cur].size(); i++) {
        		int e = adjList[cur].get(i);
        		degrees[e] -= 1;
        		if (degrees[e] > 0) continue;
        		q.offer(e);
        	}
        }
        
        System.out.println(sb);
    }
}
