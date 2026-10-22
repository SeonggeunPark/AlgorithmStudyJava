import java.util.*;

class Solution {
    public class Road implements Comparable<Road> {
        int s;
        int e;
        int w;
        public Road(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        } 
        @Override
        public int compareTo(Road o) {
            return this.w-o.w;
        }
    }
    List<Road>[] roads;
    public int solution(int N, int[][] road, int K) {
        roads = new List[N+1];
        for (int i=1; i<=N; i++){
            roads[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            roads[r[0]].add(new Road(r[0], r[1], r[2]));
            roads[r[1]].add(new Road(r[1], r[0], r[2]));
        }
        int[] dist = new int[N+1];
        dijkstra(dist, N);
        int answer = 0;
        System.out.println(Arrays.toString(dist));
        for (int i=1; i<=N; i++) {
            if (dist[i]<=K) answer+=1;
        }
        return answer;  
    }
    public void dijkstra (int[] dist, int N) {
        Queue<Road> q = new ArrayDeque<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1]=0;
        q.add(new Road(1,1,0));
        while (!q.isEmpty()) {
            Road cur = q.poll();
            for (Road r:roads[cur.e]) {
                if (dist[r.e]>dist[cur.e]+r.w) {
                    dist[r.e] = dist[cur.e]+r.w;
                    q.offer(r);
                }
            }
        }
        
    }
}