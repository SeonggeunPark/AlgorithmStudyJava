import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * 플로이드 워셜 알고리즘 사용 시 시간 초과 예상
 */
public class Main {
    static class Node implements Comparable<Node>{
        int v, w;
        public Node() {
        }
        @Override
        public String toString() {
            return "Node [v=" + v + ", w=" + w + "]";
        }
        public Node(int v, int w) {
            super();
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    static int N, M, X, max;
    static ArrayList<Node>[] adjList;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) {
        init();
        
        for (int i=1; i<=N; i++) {
            int tmp1 = dijkstra(i, X);
            int tmp2 = dijkstra(X, i);
            max = Math.max(max, tmp1+tmp2);
//            System.out.println(i+" -> "+ X + " = " + (tmp1+tmp2));
        }
        
        System.out.println(max);
    }
    
    private static int dijkstra(int start, int end) {
        int res = 0;
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        visited = new boolean[N+1];
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;    // 시작점은 거리 0
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();    // 큐에서 현제 노드 뽑음
            if (curr.v == end) {
            	return dist[curr.v];
            }
            if (visited[curr.v]) continue;
            visited[curr.v] = true;
            
            // 인접 노드 탐색
            for (Node node : adjList[curr.v]) {
                // 아직 방문 안했고, 거리가 더 작으면 갱신
                if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.w) {
                    dist[node.v] = dist[curr.v] + node.w;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
//            if (visited[end]) {
//                System.out.println(Arrays.toString(dist));
//                return dist[end];
//            }
        }
        return dist[end];
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();
        
        adjList = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) { 
            adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }
        
        max = 0;
    }
    
    

}
