import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    public int bfs(int[][] maps) {
        int cnt = 1;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int size = 1;
        while (!q.isEmpty()) {
            for (int i=0; i<size; i++) {
                int[] cur = q.poll();
                if (cur[0]==n-1 && cur[1]==m-1) {
                    return cnt;
                }
                
                for (int dir=0; dir<4; dir++) {
                    int nr = cur[0] + dr[dir];
                    int nc = cur[1] + dc[dir];
                    
                    if (nr<0||nr>=n||nc<0||nc>=m||visited[nr][nc]||maps[nr][nc]==0) continue;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});  
                }
            }
            cnt += 1;
            size = q.size();
        }
        return -1;
    }
}