import java.util.*;
// 위상정렬, 나보다 뒷순위가 없을 때만 큐에 삽입하는 방식.

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 인접리스트 생성
        List<Integer>[] winList = new List[n+1];
        List<Integer>[] loseList = new List[n+1];
        for (int i=1; i<=n; i++) {
            winList[i] = new ArrayList<>();
            loseList[i] = new ArrayList<>();
        }
        // 초기값 세팅
        for (int[] res : results) {
            winList[res[1]].add(res[0]);
            loseList[res[0]].add(res[1]);
        }
        
        for (int i=1; i<=n; i++) {
            int winners = bfs(i, winList, n);
            int losers = bfs(i, loseList, n);
            
            // System.out.println(winners +", "+ losers);
            
            if (winners+losers == n-1) answer+=1;
        }
        
        return answer;
    }
    public int bfs(int start, List<Integer>[] adjList, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int pollItem = q.poll();
            cnt += 1;
            
            for (int next : adjList[pollItem]) {
                if (visited[next]) continue;
                q.offer(next);
                visited[next] = true;
            }
        }
        
        return cnt-1;
    }
}