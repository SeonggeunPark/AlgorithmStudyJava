import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] memo;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        memo = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, DFS(i, j));
            }
        }
        System.out.println(max);
    }

    static int DFS(int r, int c) {
        // 이미 계산된 값이 있는 경우
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        // 초기 방문 시 현재 위치에서의 최대 이동 칸 수는 1
        memo[r][c] = 1;

        for (int idx = 0; idx < 4; idx++) {
            int nr = r + dr[idx];
            int nc = c + dc[idx];

            if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] > map[r][c]) {
                memo[r][c] = Math.max(memo[r][c], DFS(nr, nc) + 1);
            }
        }

        return memo[r][c];
    }
}