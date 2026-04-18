import java.util.*;

class Solution {
    List<Integer>[] adjList;
    boolean[] visited;
    int answer;
    public int solution(int n, int[][] wires) {
        adjList = new List[n+1];
        for (int i=1;i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        answer = n-1;
        visited = new boolean[n+1];
        visited[1] = true;
        DFS(1, n);
        return answer;
    }
    public int DFS(int cur, int n) {
        int res = 1;
        
        for (int next : adjList[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            int subCnt = DFS(next, n);
            answer = Math.min (answer, Math.abs(n - subCnt - subCnt));
            res += subCnt;
        }
        
        return res;
    }
}