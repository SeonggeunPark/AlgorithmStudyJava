import java.util.*;
class Solution {
    int N, M;
    char[][] map;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        N = n;
        M = m;
        // map 초기화
        map = new char[M][N];
        for (int r=0; r<M; r++) {
            for (int c=0; c<N; c++) {
                map[r][c] = board[r].charAt(c);
            }
        }
        // 더이상 변화 없을 때까지 반복
        boolean changed = true;
        while(changed) {
            changed = false;
            List<int[]> broken = new ArrayList<>();
            // 제거 대상 탐색
            for (int r=0; r<M-1; r++) {
                for (int c=0; c<N-1; c++) {
                    if (map[r][c]==' ') continue;
                    if (map[r][c]!=map[r][c+1]) continue;
                    if (map[r][c]!=map[r+1][c]) continue;
                    if (map[r][c]!=map[r+1][c+1]) continue;
                    broken.add(new int[]{r,c});
                    changed = true;
                }
            }
            // 제거
            for (int[] target : broken) {
                if (map[target[0]][target[1]]!=' ') {
                    map[target[0]][target[1]]= ' ';
                    answer += 1;
                } 
                if (map[target[0]+1][target[1]]!=' ') {
                    map[target[0]+1][target[1]]= ' ';
                    answer += 1;
                } 
                if (map[target[0]][target[1]+1]!=' ') {
                    map[target[0]][target[1]+1]= ' ';
                    answer += 1;
                } 
                if (map[target[0]+1][target[1]+1]!=' ') {
                    map[target[0]+1][target[1]+1]= ' ';
                    answer += 1;
                } 
            }
            // map 재배치
            out:
            for (int c=0; c<N; c++) {
                for (int r=M-1; r>=0; r--) {
                    if (map[r][c]!=' ') continue;
                    int idx = r-1;
                    while (idx>=0 && map[idx][c]==' ') {
                        idx -= 1;
                    }
                    if (idx<0) continue out;
                    map[r][c] = map[idx][c];
                    map[idx][c]= ' ';
                }
            }
        }
        return answer;
    }
}