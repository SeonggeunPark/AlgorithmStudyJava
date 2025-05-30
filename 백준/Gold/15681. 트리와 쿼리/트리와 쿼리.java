import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] subtreeSize;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int R = Integer.parseInt(st.nextToken()); // 루트 번호
        int Q = Integer.parseInt(st.nextToken()); // 쿼리 수

        // 트리 초기화
        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // DFS로 서브트리 크기 계산
        dfs(R);

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[u]).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs(int current) {
        visited[current] = true;
        int count = 1; // 자기 자신 포함

        for (int child : tree.get(current)) {
            if (!visited[child]) {
                count += dfs(child);
            }
        }

        subtreeSize[current] = count;
        return count;
    }
}
