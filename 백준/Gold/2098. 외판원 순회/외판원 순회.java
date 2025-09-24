import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int N;
    static int[][] W;
    static int[][] dp; // dp[cur][mask], -1이면 미계산

    static int dfs(int cur, int mask) {
        if (mask == (1 << N) - 1) { // 전부 방문 → 시작(0)으로 복귀
            return W[cur][0] == 0 ? INF : W[cur][0];
        }
        if (dp[cur][mask] != -1) return dp[cur][mask];

        int best = INF;
        for (int next = 0; next < N; next++) {
            if ((mask & (1 << next)) != 0) continue;    // 이미 방문
            if (W[cur][next] == 0) continue;            // 길 없음
            int cost = dfs(next, mask | (1 << next));
            if (cost != INF) {
                best = Math.min(best, W[cur][next] + cost);
            }
        }
        return dp[cur][mask] = best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) W[i][j] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);

        // 시작 도시는 0으로 고정 (입력이 1~N이라면 읽을 때 0-index로 바꾼 셈)
        int ans = dfs(0, 1 << 0);
        System.out.println(ans);
    }
}
