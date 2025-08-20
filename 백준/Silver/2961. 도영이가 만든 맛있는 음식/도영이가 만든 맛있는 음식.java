import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] S, B;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);

        System.out.println(min);
    }

    // idx: 현재 재료 인덱스
    // s: 신맛 곱
    // b: 쓴맛 합
    // cnt: 사용한 재료 개수
    static void dfs(int idx, int s, int b, int cnt) {
        if (idx == N) {
            if (cnt > 0) {
                min = Math.min(min, Math.abs(s - b));
            }
            return;
        }

        // 1) 해당 재료 선택
        dfs(idx + 1, s * S[idx], b + B[idx], cnt + 1);

        // 2) 해당 재료 선택 안함
        dfs(idx + 1, s, b, cnt);
    }
}
