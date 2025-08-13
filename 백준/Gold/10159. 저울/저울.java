import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] adj;     // u -> v : u가 v보다 무거움 (v가 더 가벼움)
    static List<Integer>[] radj;    // 역방향: v -> u : v가 u보다 무거움 (u가 더 가벼움)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        radj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // a가 b보다 무겁다
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);  // 정방향: a -> b (a 무거움 -> b 가벼움)
            radj[b].add(a); // 역방향: b -> a (b 가벼움 -> a 무거움)
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int lighter = bfsCount(i, adj);   // i에서 정방향으로 도달 가능한 노드 수 = i보다 가벼운 것들
            int heavier = bfsCount(i, radj);  // i에서 역방향으로 도달 가능한 노드 수 = i보다 무거운 것들
            int unknown = N - 1 - (lighter + heavier);
            sb.append(unknown).append('\n');
        }
        System.out.print(sb);
    }

    // 시작 s에서 그래프 g를 따라 도달 가능한 정점의 수(자기 자신 제외)
    static int bfsCount(int s, List<Integer>[] g) {
        boolean[] visited = new boolean[N + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[s] = true;
        q.add(s);
        int cnt = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    cnt++;
                    q.add(v);
                }
            }
        }
        return cnt;
    }
}
