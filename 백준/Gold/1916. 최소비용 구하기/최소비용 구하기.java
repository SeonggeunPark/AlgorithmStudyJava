import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] dist;
    static ArrayList<Node>[] adjList; 
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int v; // 목적지 노드
        int w; // 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        // 인접 리스트 초기화
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        // 간선 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adjList[u].add(new Node(v, w)); // 방향 그래프
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        
        dijkstra(start);

        // 도달할 수 없는 경우 처리
        if (dist[end] == INF) {
            System.out.println(-1); // 도달 불가
        } else {
            System.out.println(dist[end]);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N + 1]; // 노드 수에 맞게 초기화
        Arrays.fill(dist, INF);
        
        dist[start] = 0;
        pq.add(new Node(start, 0)); // 시작 노드를 우선순위 큐에 추가

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 현재 노드의 거리가 저장된 거리보다 크면 무시
            if (curr.w > dist[curr.v]) continue;

            for (Node node : adjList[curr.v]) {
                // 현재 노드를 통해 가는 거리
                int newDist = dist[curr.v] + node.w;

                // 새로운 거리로 갱신
                if (newDist < dist[node.v]) {
                    dist[node.v] = newDist;
                    pq.add(new Node(node.v, newDist)); // 새로운 거리로 노드 추가
                }
            }
        }
    }
}
