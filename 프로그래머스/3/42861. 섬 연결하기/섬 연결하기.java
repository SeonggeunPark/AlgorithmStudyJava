import java.util.*;

class Solution {
    public class Edge implements Comparable<Edge> {
        int s, e, w;
        public Edge(int s, int e, int w) {
            this.s=s;
            this.e=e;
            this.w=w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.w-o.w;
        }
    }
    public int solution(int n, int[][] costs) {
        int len = costs.length;
        Edge[] edges = new Edge[len];
        int idx=0;
        for (int[] cost:costs) {
            edges[idx++] = new Edge(cost[0], cost[1], cost[2]);
        }
        Arrays.sort(edges);
        
        int[] p = new int[len+1];
        for (int i=0; i<n; i++) {
            p[i]=i;
        }
        
        int pick = 0;
        int cost = 0;
        for (Edge edge:edges) {
            if (find(edge.s, p) != find(edge.e, p)) {
                union(edge.s, edge.e, p);
                pick+=1;
                cost+=edge.w;
            }
            if (pick > n) break;
        }
        
        return cost;
    }
    public int find(int x, int[] p) {
        if (p[x]==x) return x;
        return p[x] = find(p[x], p);
    }
    public void union(int x, int y, int[] p) {
        p[find(x, p)] = find(y, p);
    }
}