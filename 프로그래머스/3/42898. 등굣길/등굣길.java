class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[m+1][n+1];
        boolean[][] isPuddle = new boolean[m+1][n+1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[0]][puddle[1]] = true;
        }
        for (int i=1; i<=m; i++) {
            if (isPuddle[i][1]) break;
            dp[i][1] = 1;
        }
        for (int i=1; i<=n; i++) {
            if (isPuddle[1][i]) break;
            dp[1][i] = 1;
        }
        for (int r=2; r<=m; r++) {
            for (int c=2; c<=n; c++) {
                if (isPuddle[r][c]) continue;
                dp[r][c] = (dp[r-1][c]+dp[r][c-1])%1000000007;
            }
        }
        
        return dp[m][n];
    }
}