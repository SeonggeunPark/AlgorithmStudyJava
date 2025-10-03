import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // p[0..N] : 차원 배열. i번째 행렬은 p[i-1] x p[i]
        int[] p = new int[N + 1];
        int[][] rc = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rc[i][0] = Integer.parseInt(st.nextToken()); // r
            rc[i][1] = Integer.parseInt(st.nextToken()); // c
        }
        // p 채우기 (보장: rc[i][1] == rc[i+1][0])
        p[0] = rc[0][0];
        for (int i = 0; i < N; i++) p[i + 1] = rc[i][1];

        long[][] dp = new long[N][N]; // dp[i][j] : i..j 곱 최소 비용
        for (int len = 2; len <= N; len++) {     // 구간 길이
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;
                long best = Long.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j] + 1L * p[i] * p[k + 1] * p[j + 1];
                    if (cost < best) best = cost;
                }
                dp[i][j] = best;
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}
