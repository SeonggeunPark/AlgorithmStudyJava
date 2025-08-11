import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        boolean[][] adj = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                adj[i][j] = (s.charAt(j) == 'Y');
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            boolean[] twoFriend = new boolean[N];

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                // 1단계 친구
                if (adj[i][j]) {
                    twoFriend[j] = true;
                    continue;
                }

                // 2단계 친구: 공통 친구 k 존재 여부
                for (int k = 0; k < N && !twoFriend[j]; k++) {
                    if (adj[i][k] && adj[k][j]) {
                        twoFriend[j] = true;
                    }
                }
            }

            int cnt = 0;
            for (int j = 0; j < N; j++) if (twoFriend[j]) cnt++;
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
