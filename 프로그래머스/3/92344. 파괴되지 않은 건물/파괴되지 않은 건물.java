import java.util.*;

// 어떻게 누적...??
class Solution {
    public int solution(int[][] board, int[][] skills) {
        int N = board.length;
        int M = board[0].length;
        int[][] sum = new int[N+1][M+1];
        
        for (int[] skill : skills) {
            applySkill(skill, sum);
        }
        treatSum(sum, N, M);
        
        int answer = 0;
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                if (board[r][c]+sum[r][c]>=1) answer+=1;
            }
        }
        return answer;
    }
    public void applySkill(int[] skill, int[][] sum) {
        int degree = skill[5];
        if (skill[0]==1) {
            degree *= -1;
        }
            sum[skill[1]][skill[2]] += degree;
            sum[skill[1]][skill[4]+1] -= degree;
            sum[skill[3]+1][skill[2]] -= degree;
            sum[skill[3]+1][skill[4]+1] += degree;
    }
    public void treatSum(int[][] sum, int N, int M) {
        for (int r=0; r<N+1; r++) {
            for (int c=1; c<M+1; c++) {
                sum[r][c] += sum[r][c-1];
            }
        }
        for (int c=0; c<M+1; c++) {
            for (int r=1; r<N+1;r++) {
                sum[r][c] += sum[r-1][c];
            }
        }
    }
}