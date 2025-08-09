import java.util.*;

class Solution {
    class Edge implements Comparable<Edge>{
        int s;
        int e;
        int w;
        
        Edge (int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        
        @Override
        public int compareTo (Edge o) {
            return this.w - o.w;
        }
        
        @Override
        public String toString() {
            return this.s +", "+this.e+", "+this.w;
        }
    }
    static int[] p;
    public int solution(int n, int[][] costs) {
        // 간선을 객체화하여 배열 저장
        Edge[] edges = new Edge[costs.length];
        for (int i=0; i<costs.length; i++) {
            edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }
        
        // 가중치 기준 오름차순 정렬
        Arrays.sort(edges);
   
        
        // 트리를 이용한 union-find
        // 노드별 최상위 노드 기록 배열
        p = new int[n+1];
        for (int i=1; i<=n; i++) {
            p[i] = i;
        }
        
        // kruskal 알고리즘
        int cnt = 0;
        int ans = 0;
        for (int i=0; i<edges.length; i++) {
            Edge curr = edges[i];
            int px = find(curr.s);
            int py = find(curr.e);
            
            if (px == py) continue;
            
            union(curr.s, curr.e);
            cnt += 1;
            ans += curr.w;
            
            if (cnt >= n-1) break;
        }
        
        return ans;
    }
    void union(int x, int y) {
        p[find(x)] = find(y);
    }
    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}