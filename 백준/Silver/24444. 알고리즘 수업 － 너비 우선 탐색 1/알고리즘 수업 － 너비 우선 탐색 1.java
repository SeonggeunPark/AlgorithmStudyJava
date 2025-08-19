import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] adj;
    static int[] order;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= N; i++) Collections.sort(adj[i]); // 오름차순

        order = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(order[i]).append('\n');
        System.out.print(sb);
    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int cnt = 0;

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            order[u] = ++cnt;
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }
}
