import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int N, K, W;
    static int[] durations;
    static boolean[] visited;   // 남겨두되 미사용
    static boolean[] isBuilt;   // 남겨두되 미사용
    static PriorityQueue<Building> ready;
    static ArrayList<Integer>[] next;
    static ArrayList<Integer>[] prev;

    static class Building implements Comparable<Building> {
        int num;
        int finishTime; // ← leftTime 대신 '완료 예정 시각'으로 의미 변경

        public Building(int num, int finishTime) {
            this.num = num;
            this.finishTime = finishTime;
        }

        @Override
        public int compareTo(Main.Building o) {
            return Integer.compare(this.finishTime, o.finishTime); // 완료가 빠른 순
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            init();
            System.out.println(simulation()); // W가 완성되는 가장 이른 시간
        }
    }

    private static int simulation() {
        ready = new PriorityQueue<>();

        // indegree 및 '선행 중 최댓값' 배열 준비
        int[] indeg = new int[N + 1];
        int[] bestStart = new int[N + 1]; // 각 건물의 공사 시작 가능 최종 시각(선행 중 최댓값)

        for (int v = 1; v <= N; v++) {
            indeg[v] = prev[v].size();
        }

        // 선행 없는 건물들: 자신의 duration으로 완료 예정시각 결정
        for (int v = 1; v <= N; v++) {
            if (indeg[v] == 0) {
                ready.offer(new Building(v, durations[v]));
            }
        }

        // 시뮬레이션
        while (!ready.isEmpty()) {
            Building cur = ready.poll();
            int u = cur.num;
            int finishU = cur.finishTime;

            if (u == W) {
                return finishU; // 목표 건물 W 완성 시점이 정답
            }

            // 후속 건물 갱신
            for (int v : next[u]) {
                // 선행들의 완료시각 중 최댓값을 유지
                if (bestStart[v] < finishU) bestStart[v] = finishU;

                if (--indeg[v] == 0) {
                    // 모든 선행이 끝났으니, 시작 가능 시각 = bestStart[v]
                    // 완료 예정 시각 = bestStart[v] + durations[v]
                    ready.offer(new Building(v, bestStart[v] + durations[v]));
                }
            }
        }

        // 이론상 도달 불가면 0 (문제 조건상 DAG이므로 여기 오기 어렵지만 방어)
        return 0;
    }

    private static void init() throws IOException {
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 건물 수
        K = Integer.parseInt(st.nextToken()); // 건설순서 규칙 수

        durations = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            durations[i] = Integer.parseInt(st.nextToken());
        }

        next = new ArrayList[N + 1];
        prev = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            next[i] = new ArrayList<>();
            prev[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            next[s].add(e);
            prev[e].add(s);
        }

        visited = new boolean[N + 1]; // 미사용
        isBuilt = new boolean[N + 1]; // 미사용
        W = Integer.parseInt(br.readLine());
    }
}
