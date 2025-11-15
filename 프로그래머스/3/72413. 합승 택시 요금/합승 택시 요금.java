import java.util.*;
        /*
        합승 시 시작지점부터 모든 지점까지 다익스트라로 최단거리 기록
        해당 최단거리에다가, A B 각각 목적지까지 최단거리를 (BFS or 플로이드워셜)로 추가로 구함.
        */
class Solution {
    public class Node implements Comparable<Node>{
        int v, w;
        public Node(int v, int w) {
            this.v=v;
            this.w=w;
        }
        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 인접리스트 작성
        List<Node>[] adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            adjList[c].add(new Node(d,f));
            adjList[d].add(new Node(c,f));
        }
        
        int[] dist = new int[n+1];
        // 다익스트라로 각 정점까지의 최단거리 산정
        dijkstra(s, dist, adjList);
        // 합승으로 도달가능한 정점에서 A, B까지 각각 최단거리
        int[][] fwDist = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            Arrays.fill(fwDist[i],Integer.MAX_VALUE);
        }
        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            fwDist[c][d] = f;
            fwDist[d][c] = f;
        }
        // k를 거치고 가는 최단거리
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                if (k==i) continue;
                for (int j=1; j<=n; j++) {
                    if (i==j) {
                        fwDist[i][j] = 0;
                        fwDist[j][i] = 0;
                        continue;
                    }
                    if (fwDist[i][k] != Integer.MAX_VALUE && fwDist[k][j] != Integer.MAX_VALUE)
                    fwDist[i][j] = Math.min(fwDist[i][k]+fwDist[k][j], fwDist[i][j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        // 합승종료지점부터 거리 완전탐색
        for (int start=1; start<=n; start++) {
            if (fwDist[start][a] == Integer.MAX_VALUE 
                || fwDist[start][b] == Integer.MAX_VALUE
                || fwDist[s][start] == Integer.MAX_VALUE) continue;
            int cur = fwDist[s][start] + fwDist[start][b] + fwDist[start][a];
            answer = Math.min(answer, cur);
        }
        
        return answer;
    }
    public void dijkstra(int start, int[] dist, List<Node>[] adjList) {
        // 시작지점 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        // 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            // 인접노드 탐색
            for (Node adjNode: adjList[curNode.v]) {
                // 최단거리 갱신
                if (dist[curNode.v]+adjNode.w < dist[adjNode.v]) {
                    dist[adjNode.v] = dist[curNode.v]+adjNode.w;
                    pq.offer(new Node(adjNode.v, dist[adjNode.v]));
                }
            }
        }
    }
}