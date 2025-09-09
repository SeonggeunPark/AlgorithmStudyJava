import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;     // 중복 제거된 배열
    static int[] pick;     // 현재 수열
    static StringBuilder sb = new StringBuilder();

    static void dfs(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                if (i > 0) sb.append(' ');
                sb.append(pick[i]);
            }
            sb.append('\n');
            return;
        }
        for (int x : nums) {
            pick[cnt] = x;
            dfs(cnt + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] raw = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) raw[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(raw);
        // 중복 제거
        int cnt = 0;
        int prev = Integer.MIN_VALUE;
        for (int x : raw) {
            if (cnt == 0 || x != prev) {
                raw[cnt++] = x;
                prev = x;
            }
        }
        nums = Arrays.copyOf(raw, cnt);

        pick = new int[M];
        dfs(0);
        System.out.print(sb.toString());
    }
}
