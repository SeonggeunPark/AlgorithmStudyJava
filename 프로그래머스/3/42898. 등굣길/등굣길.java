import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        boolean[][] puddleCheck = new boolean[m+1][n+1];
        
        for (int[] pos : puddles) {
            puddleCheck[pos[0]][pos[1]] = true;
        }
        
        dp[1][1] = 1;
        for (int r=1; r<=m; r++) {
            for (int c=1; c<=n; c++) {
                if(puddleCheck[r][c]) {
                    continue;
                } else {
                    if (r-1>0) {
                        dp[r][c] += dp[r-1][c];
                        dp[r][c] %= 1000000007;
                    }
                    if (c-1>0) {
                        dp[r][c] += dp[r][c-1];
                        dp[r][c] %= 1000000007;
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}