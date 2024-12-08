import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, targetR, targetC;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] ans;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        ans = new int[n][m];
        q = new LinkedList<>();

        targetR = -1;
        targetC = -1;
        
        // 지도 정보 입력
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                int num = Integer.parseInt(st.nextToken());
                map[r][c] = num;
                if (num == 2) {  // 목표지점(2)을 찾으면
                    targetR = r;
                    targetC = c;
                }
                ans[r][c] = -1; // 초기 값은 -1로 설정
            }
        }

        // 목표 지점에서부터 BFS 시작
        BFS(targetR, targetC);
        
        // 결과 출력
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] == 0) {  // 벽은 0으로 표시
                    sb.append(0).append(' ');
                } else {
                    sb.append(ans[r][c]).append(' ');
                }
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
    }

    private static void BFS(int r, int c) {
        // 목표 지점부터 BFS 시작
        q.add(new int[] {r, c});  // 목표 지점 큐에 삽입
        ans[r][c] = 0;  // 목표지점의 거리는 0

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            // 사방 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nr = currR + dr[dir];
                int nc = currC + dc[dir];

                // 범위 체크 및 이미 방문한 곳은 패스
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == 0) continue;  // 벽인 곳은 패스
                if (ans[nr][nc] != -1) continue;  // 이미 방문한 곳은 패스

                // 거리 계산
                ans[nr][nc] = ans[currR][currC] + 1;
                q.add(new int[] {nr, nc});
            }
        }
    }
}
