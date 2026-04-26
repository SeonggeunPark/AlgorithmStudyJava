import java.util.*;
                    
class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int n;
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        n = game_board.length;
        // table 탐색
        // 아직 탐색 안한 퍼즐 있는지 체크
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                if (table[r][c]==0) continue;
                // 퍼즐 모양 기록(좌표)
                List<int[]> poses = new ArrayList<>();
                definePuzzle(poses, r, c, table);
                // 좌표 표준화
                standardize(poses);
                // for (int[] pos : poses) {
                //     System.out.print("["+pos[0]+", "+pos[1]+"], ");
                // }
                // System.out.println();
                
                // game_board의 빈칸 탐색해 모양 비교
                out:
                for (int x=0; x<n; x++) {
                    for (int y=0; y<n; y++) {
                        if (game_board[x][y]==1) continue;
                        // 1. 개수 비교 (개수 안맞으면 pass)
                        if (countBlank(game_board, x, y) != poses.size()) continue;
                        // 2. 모양 비교 (4방향: 맞는게 있으면 채우고 answer 누적)
                        for (int i=0; i<4; i++) {
                            // 체크
                            if (check(poses, game_board, x, y)) {
                                fillBlank(game_board, x, y);
                                answer += poses.size();
                                // System.out.println(x+", "+y+"  맞음");
                                break out;
                            }
                            // 회전
                            rotateCounterClockWise(poses);
                        }
                    }
                }
            }
        }
        return answer;
    }
    // 빈칸 만들면서 작업 수행
    public void definePuzzle(List<int[]> poses, int r, int c, int[][] table) {
        poses.add(new int[]{r, c});
        table[r][c]=0;
        // 4방 탐색
        for (int dir = 0; dir < 4; dir ++) {
            int nr = r+dr[dir];
            int nc = c+dc[dir];
            if (nr<0 || nr>=n || nc<0 || nc>=n || table[nr][nc]==0) continue;
            definePuzzle(poses, nr, nc, table);
        }
    }
    
    public int countBlank(int[][] game_board, int r, int c) {
        boolean[][] visited = new boolean[n][n]; // 같은 칸 중복 카운트 방지
        return countBlankDfs(game_board, r, c, visited);
    }

    public int countBlankDfs(int[][] game_board, int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        int res = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (game_board[nr][nc] == 1 || visited[nr][nc]) continue;

            res += countBlankDfs(game_board, nr, nc, visited);
        }

        return res;
    }
    public boolean check(List<int[]> poses, int[][] game_board, int r, int c) {
        for (int[] pos : poses) {
            int nr = pos[0]+r;
            int nc = pos[1]+c;
            if (nr<0 || nr>=n || nc<0 || nc>=n || game_board[nr][nc]==1) return false;
        }
        return true;
    }
    public void rotateCounterClockWise(List<int[]> poses) {
        for (int i=0; i<poses.size(); i++) {
            poses.add(new int[] {poses.get(0)[1], poses.get(0)[0]*-1});
            poses.remove(0);
        }
    }
    public void fillBlank(int[][] game_board, int r, int c) {
        game_board[r][c] = 1; // 폐쇄
        
        // 4방 탐색
        for (int dir = 0; dir < 4; dir ++) {
            int nr = r+dr[dir];
            int nc = c+dc[dir];
            if (nr<0 || nr>=n || nc<0 || nc>=n || game_board[nr][nc]==1) continue;
            fillBlank(game_board, nr, nc);
        }
    }
    public void standardize(List<int[]> poses) {
        int r = poses.get(0)[0];
        int c = poses.get(0)[1];
        
        for (int i=0; i<poses.size(); i++) {
            poses.add(new int[] {poses.get(0)[0]-r, poses.get(0)[1]-c});
            poses.remove(0);
        }
    }
}