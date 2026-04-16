class Solution {
    int solution(int[][] land) {
        int len = land.length;
        int[][] dp = new int[len][4];
        for (int i=0; i<4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i=1; i<len; i++) {
            for (int col = 0; col < 4; col ++ ) {
                dp[i][col] = land[i][col];
                int max = 0;
                for (int j=0; j<4; j++) {
                    if (j==col) continue;
                    max = Math.max(max, dp[i-1][j]);
                }
                dp[i][col] += max;
            }
        }
        int answer = 0;
        for (int i=0; i<4; i++) {
            answer = Math.max(answer, dp[len-1][i]);
        }
        return answer;
    }
}