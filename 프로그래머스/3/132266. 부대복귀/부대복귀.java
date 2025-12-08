import java.util.*;

class Solution {
    public final int INF = Integer.MAX_VALUE;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int aIdx=0;
        
        List<Integer>[] adjList = new List[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] road: roads) {
            adjList[road[0]].add(road[1]);
            adjList[road[1]].add(road[0]);
        }
        
        // for (int source : sources) {
        //     answer[aIdx++] = dijkstra(source, destination, adjList, n);
        // }
        Map<Integer, Integer> sourceMap = new HashMap<>();
        BFS(destination, sources, n, sourceMap, adjList);
        for (int i=0; i<sources.length; i++) {
            answer[i] = sourceMap.get(sources[i]);
        }
        
        return answer;
    }
    // 목표지점부터 sources까지 탐색
    public void BFS(int s, int[] sources, int n, Map<Integer, Integer> sourceMap, List<Integer>[] adjList) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        boolean[] visited =new boolean[n+1];
        visited[s] = true;
        int find = 0;
        int size =1 ;
        int cnt = 0;
        
        while(!q.isEmpty()) {
            if (find >= sources.length) return;
            for (int i=1; i<=size; i++) {
                int poll = q.poll();
                for (int source:sources) {
                    if (poll==source) {
                        sourceMap.put(poll, cnt);
                        find+=1;
                        break;
                    }
                }
                for (int next : adjList[poll]) {
                    if (visited[next]) continue;
                    q.offer(next);
                    visited[next] = true;
                }
            }
            size = q.size();
            cnt+=1;
        }
        
        for (int source : sources) {
            if (sourceMap.get(source) == null) {
                sourceMap.put(source, -1);
            }
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