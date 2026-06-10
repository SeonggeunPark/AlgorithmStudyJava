import java.util.*;
/*
dp[n] =
1) +인 경우 -> dp[n-1]+arr[n];
2) -인 경우 ->

dp[n][m] = n번째 수부터 m번째 수까지 연산 결과의 최대값
dp[n][m] = 
1) +인 경우 -> dp[n][m-1] + arr[m];
2) -인 경우 -> MAX(cal(dp[n][m-1],dp[m][m]), cal(dp[n][m-2], dp[m-1][m]), ...);
00-11
01-22 00-12 
00 11 22 33 44 55
10 01 21 12 32 23 43 34 54 45
20 02 
*/
class Solution {
    public int solution(String arr[]) {
        int len = arr.length/2+1;
        char[] operands = new char[len-1];
        int[] operators = new int[len];
        
        for (int i=0; i<arr.length; i++) {
            if (i%2==0) operators[i/2] = Integer.parseInt(arr[i]);
            else operands[i/2] = arr[i].charAt(0);
        }
        
        int[][] maxdp = new int[len][len];
        int[][] mindp = new int[len][len];
        for (int i=0; i<len; i++ ) {
            maxdp[i][i] = operators[i];
            mindp[i][i] = operators[i];
        }
        
        for (int diff=1; diff<len; diff++) {
            for (int s = 0; s+diff<len; s++ ) {
                int e = s + diff;
                int max = -100000;
                int min = 101000;
                for (int i=1; i<=diff; i++) {
                    max = Math.max(max, calMax(s, e, i, maxdp, mindp, operands[e-i]));
                    min = Math.min(min, calMin(s, e, i, maxdp, mindp, operands[e-i]));
                }
                maxdp[s][e] = max;
                mindp[s][e] = min;
                // System.out.println("dp["+s+"]["+e+"] = "+dp[s][e]);
            }
        }
        
        return maxdp[0][len-1];
    }
    public int calMax(int s, int e, int i, int[][] maxdp, int[][] mindp, char op) {
        if (op=='+') return maxdp[s][e-i]+maxdp[e-i+1][e];
        else return maxdp[s][e-i]-mindp[e-i+1][e];
    }
    public int calMin(int s, int e, int i, int[][] maxdp, int[][] mindp, char op) {
        if (op=='+') return mindp[s][e-i]+mindp[e-i+1][e];
        else return mindp[s][e-i]-maxdp[e-i+1][e];
    }
}