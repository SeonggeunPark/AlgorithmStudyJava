import java.util.*;
/*
열쇠 회전/이동 가능
모든 경우를 비교해봐야함
- 패딩필요: (N+2*(M-1)*(N+M-1)
- 최악의 경우의수: 58*58*4(회전)*40*40 = 21,529,600
*/
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;
        // M-1패딩을 가진 자물쇠 배열 생성
        int[][] board = new int[N+2*M-2][N+2*M-2];
        int nL = board.length;
        // 완전탐색 시작
        // 아예 열쇠가 안겹치는 경우
        if (checkKey(board, new int[M][M], lock, 0, 0, N, M)) return true; 
        for (int d=0; d<4; d++) { // 방향전환용
            //탐색
            for (int r=0; r<=nL-M; r++) {
                for (int c=0; c<=nL-M; c++) {
                    // 자물쇠-열쇠 검증
                    if (checkKey(board, key, lock, r, c, N, M)) return true;
                    
                    // board 원상복구
                    for (int i=r; i<r+M; i++) {
                        for (int j=c; j<c+M; j++) {
                            board[i][j] = 0;
                        }
                    }
                }
            }
            
            // 방향전환
            if (d==4) continue;
            rotateKey(key);
        }
        return false;
    }
    public boolean checkKey(int[][] board, int[][] key, int[][] lock, 
                            int sR, int sC, int N, int M) {
        // 열쇠 위치
        for (int r=sR; r<sR+M; r++) {
            for (int c=sC; c<sC+M; c++) {
                board[r][c] = key[r-sR][c-sC];
            }
        }
        
        // 매칭
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (lock[r][c]==1 && board[r+M-1][c+M-1]==1) return false;
                if (lock[r][c]==0 && board[r+M-1][c+M-1]==0) return false;
            }
        }
        
        return true;
    }
    // 오른쪽 90도 회전
    public void rotateKey(int[][] key) {
        int M = key.length;
        int[][] tmp = new int[M][M];
        for (int r=0; r<M; r++) {
            for (int c=0; c<M; c++) {
                tmp[c][M-r-1] = key[r][c];
            }
        }
        for (int r=0; r<M; r++) {
            for (int c=0; c<M; c++) {
                key[r][c]=tmp[r][c];
            }
        }
    }
}