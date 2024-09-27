import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] box;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        
        box = new int[N][M];
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                box[r][c] = sc.nextInt();
                if (box[r][c] == 1) {
                    queue.offer(new int[]{r, c});  // 익은 토마토를 큐에 추가
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isRipeToday = false;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || box[nr][nc] != 0) {
                        continue;
                    }

                    box[nr][nc] = 1;
                    queue.offer(new int[]{nr, nc});
                    isRipeToday = true;
                }
            }

            if (isRipeToday) {
                day++;
            }
        }

        // 아직 익지 않은 토마토가 있는지 확인
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 0) {
                    return -1;
                }
            }
        }

        return day;
    }
}
