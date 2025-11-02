import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            dfs(i, n, visited, computers);
            answer += 1;
        }
        
        return answer;
    }
    public void dfs(int v, int n, boolean[] visited, int[][] computers) {
        if (visited[v]) return;
        visited[v] = true;
        
        for (int i=0; i<n; i++) {
            if (computers[v][i] != 1) continue;
            dfs(i, n, visited, computers);
        }
    }
}