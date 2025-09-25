import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] pick;
    static boolean[] visited, finished;
    static int teamCnt;

    static void dfs(int u) {
        visited[u] = true;
        int v = pick[u];

        if (!visited[v]) {
            dfs(v);
        } else if (!finished[v]) {
            int x = v;
            teamCnt++;                 
            while (pick[x] != v) {    
                x = pick[x];
                teamCnt++;
            }
        }
        finished[u] = true; 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine().trim());
            pick = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            teamCnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) pick[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }
            sb.append(n - teamCnt).append('\n');
        }
        System.out.print(sb);
    }
}
