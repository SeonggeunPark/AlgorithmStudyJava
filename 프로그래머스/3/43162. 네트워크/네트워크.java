import java.util.*;


class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
	
	boolean[] visited = new boolean[n];
	for (int i=0; i<n; i++) {
		if (visited[i]) continue;
		dfs(i, n, visited, computers);
		answer+=1;
	}

        return answer;
    }
    public void dfs(int v, int n, boolean[] visited, int[][] computers) {
        for (int i=0; i<n; i++) {
            if (i==v) continue;
            if (computers[v][i]==0) continue;
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i, n, visited, computers);
        }
    }
}