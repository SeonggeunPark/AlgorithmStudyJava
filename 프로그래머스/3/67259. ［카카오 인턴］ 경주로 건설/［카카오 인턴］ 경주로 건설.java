/*
bfs로 탐색
r, c, 방향 3개 저장
visited 배열로 총금액 누적 -> 누적금액이 낮거나 방문기록 없을때만 이동
*/
import java.util.*;
class Solution {
    // 상 하 좌 우
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(int[][] board) {
        int N = board.length;
        int answer = bfs(board, N);
        return answer;
    }
    public int bfs(int[][] board, int N) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] visited = new int[N][N][4];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i=0 ; i<4; i++) {
            visited[0][0][i] = 0;
        }
        // 하, 우방향 각각 삽입
        q.offer(new int[]{0, 0, 1});
        q.offer(new int[]{0, 0, 3});
        
        // 순회
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            // System.out.println(r+", "+c+" - "+d);
            
            if (r==N-1 && c==N-1) continue;
            
            // 이동
            for (int dir = 0; dir<4; dir++) {
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                
                if ((d==0&&dir==1)||(d==1&&dir==0)||(d==2&&dir==3)||(d==3&&dir==2)) continue;
                if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if (board[nr][nc]==1) continue;
                
                int cost = visited[r][c][d] + 100;
                if (d!=dir) {
                    cost += 500;
                }
                if (cost > visited[nr][nc][dir]) continue;
                visited[nr][nc][dir] = cost;
                q.offer(new int[]{nr, nc, dir});
            }
        }
        int res = visited[N-1][N-1][0];
        for (int i=1; i<4;i++) {
            res = Math.min(res,visited[N-1][N-1][i]);
        }
        return res;
    }
}