import java.util.*;

class Solution {
    public final int INF = Integer.MAX_VALUE;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<Integer>[] adjList = new List[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] road: roads) {
            adjList[road[0]].add(road[1]);
            adjList[road[1]].add(road[0]);
        }
        
        // int aIdx = 0;
        // for (int source : sources) {
        //     answer[aIdx++] = dijkstra(source, destination, adjList, n);
        // }
        
        int[] visited =new int[n+1];
        Arrays.fill(visited, -1);
        BFS(destination, sources, n, adjList, visited);
        for (int i=0; i<sources.length; i++) {
            answer[i] = visited[sources[i]];
        }
        
        return answer;
    }
    // 목표지점부터 sources까지 탐색
    public void BFS(int s, int[] sources, int n, List<Integer>[] adjList, int[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        visited[s] = 0;
        int size =1 ;
        int cnt = 1;
        
        while(!q.isEmpty()) {
            for (int i=1; i<=size; i++) {
                int poll = q.poll();
                for (int next : adjList[poll]) {
                    if (visited[next] > -1) continue;
                    q.offer(next);
                    visited[next] = cnt;
                }
            }
            size = q.size();
            cnt+=1;
        }
    }
    public class Node implements Comparable<Node> {
        int v;
        int w;
        Node (int v, int w) {
            this.v=v;
            this.w=w;
        }
        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    public int dijkstra(int s, int e, List<Integer>[] adjList, int n) {
        int[] dist = new int[n+1];
        boolean[] visited =new boolean[n+1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        visited[s] = true;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (curNode.v == e) {
                return dist[e];
            }
            
            for (int next : adjList[curNode.v]) {
                if (visited[next]) continue;
                if (dist[next] > dist[curNode.v]+1) {
                    dist[next] = dist[curNode.v]+1;
                    pq.offer(new Node(next, dist[curNode.v]+1));
                    visited[next] = true;
                }
            }
            
        }
        
        return -1;
        
    }
}