import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N;
    // shark: [0]=r, [1]=c, [2]=size, [3]=eaten
    static int[] shark = new int[4];
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(simulation());
    }

    static class Node implements Comparable<Node> {
        int r, c, dist;
        Node(int r, int c, int dist) {
            this.r = r; this.c = c; this.dist = dist;
        }
        @Override
        public int compareTo(Node n) {
            if (this.dist != n.dist) return Integer.compare(this.dist, n.dist);
            if (this.r != n.r)       return Integer.compare(this.r, n.r);
            return Integer.compare(this.c, n.c);
        }
    }

    // 상, 좌, 하, 우  (제시 코드의 dirs와 동일 순서)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = { 0,-1, 0, 1};

    // 제시 코드의 playGame() 로직을 네 simulation() 틀에 이식
    private static int simulation() {
        int time = 0;

        // 탐색 시작 상태
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] visited = new int[N][N];

        visited[shark[0]][shark[1]] = 1;
        pq.offer(new Node(shark[0], shark[1], 1));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 먹을 수 있는 물고기를 만났다면 즉시 먹기
            if (map[cur.r][cur.c] != 9 && map[cur.r][cur.c] != 0 && map[cur.r][cur.c] < shark[2]) {
                time += (cur.dist - 1);

                // 상어 위치/맵 갱신
                map[shark[0]][shark[1]] = 0;
                map[cur.r][cur.c] = 9;
                shark[0] = cur.r;
                shark[1] = cur.c;

                // 먹은 수/크기 갱신
                shark[3] += 1;
                if (shark[3] == shark[2]) {
                    shark[3] = 0;
                    shark[2] += 1;
                }

                // 탐색 리셋
                pq.clear();
                visited = new int[N][N];
                visited[shark[0]][shark[1]] = 1;
                pq.offer(new Node(shark[0], shark[1], 1));

                continue; // 다음 먹이 탐색
            }

            // 사방 확장
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc] > 0) continue;
                if (map[nr][nc] > shark[2]) continue; // 더 큰 물고기는 통과 불가

                visited[nr][nc] = visited[cur.r][cur.c] + 1;
                pq.offer(new Node(nr, nc, visited[nr][nc]));
            }
        }

        return time;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int n = Integer.parseInt(st.nextToken());
                map[r][c] = n;
                if (n == 9) {
                    shark[0] = r;
                    shark[1] = c;
                    shark[2] = 2; // 초기 크기
                }
            }
        }
    }
}
