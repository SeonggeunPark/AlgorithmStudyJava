import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static int[][] map;
    static int[][] tmp;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = sc.nextInt();
            }
        } // 입력 완료

        int year = 0;
        while (true) {
            // 빙산이 다 녹았는지 확인
            if (meltCheck()) {
                System.out.println(0);
                return;
            }

            year++;
            melt(); // 빙산 녹이기
            
            boolean isBreak = isBreak();
            if (isBreak) {
            	System.out.println(year);
                return;
            }
        }
    }

    // 빙산 녹이기
    private static void melt() {
        tmp = new int[N][M];
        
        for (int r = 1; r < N-1; r++) {
            for (int c = 1; c < M-1; c++) {
                if (map[r][c] == 0) continue;

                int emptyCnt = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if (map[nr][nc] == 0) {
                        emptyCnt++;
                    }
                }

                tmp[r][c] = emptyCnt;
            }
        }

        // 녹이기 작업
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = Math.max(0, map[r][c] - tmp[r][c]);
            }
        }
    }

    // 빙산 덩어리 개수 세기
    private static boolean isBreak() {
    	visited = new boolean[N][M];
    	int count = 0;
    	
    	for (int r = 1; r < N-1; r++) {
    		for (int c = 1; c < M-1; c++) {
    			if (map[r][c] > 0 && !visited[r][c]) {
    				BFS(r, c); // BFS를 사용하여 덩어리 탐색
    				count++;
    			}
    			if (count > 1) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }

    // BFS 탐색
    private static void BFS(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cr = curr[0];
            int cc = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if (map[nr][nc] > 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    // 빙산이 다 녹았는지 확인
    private static boolean meltCheck() {
        for (int r = 1; r < N-1; r++) {
            for (int c = 1; c < M-1; c++) {
                if (map[r][c] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
