import java.util.*;

class Solution {
    int max = 0;
    public int solution(int n, int[][] edge) {
        List<Integer>[] adjList = new List[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        int answer = BFS(1, edge, n, adjList);
        return answer;
    }
    public int BFS(int start, int[][] edge, int n, List<Integer>[] adjList) {
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        Queue<Integer> q = new ArrayDeque();
        q.offer(start);
        int size = 1;
        int res = 0;
        
        while (!q.isEmpty()) {
            res = size;
            for (int i=1; i<=size; i++) {
                int poll = q.poll();
                for (int e : adjList[poll]) {
                    if (visited[e]) continue;
                    q.offer(e);
                    visited[e] = true;
                }
            }
            size = q.size();
        }
        
        return res;
    }
}