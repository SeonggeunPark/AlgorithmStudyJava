import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k, count;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 동전 종류 수
        k = Integer.parseInt(st.nextToken());   // 목표 가치

        // 동전 가치 입력
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

//        Arrays.sort(coins); // 동전 가치 순으로 정렬

        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i-coin];
            }
        }
        System.out.println(dp[k]);
    }

}