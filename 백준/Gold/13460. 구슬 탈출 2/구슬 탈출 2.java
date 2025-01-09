import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Bead {
        int r, c;   // 현 위치
        int move;   // 1턴 안에서 움직인 거리
        int beforeDir; // 이전 턴의 방향(현재는 크게 사용 X)

        public Bead() {}
        public Bead(int r, int c, int move, int beforeDir) {
            this.r = r;
            this.c = c;
            this.move = move;
            this.beforeDir = beforeDir;
        }
    }

    static int N, M;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] hole;
    static Bead red, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        red = new Bead();
        blue = new Bead();
        hole = new int[2];

        map = new char[N][M];
        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }
        // 구슬과 구멍 위치 확인
        findObjects();

        // BFS 작업 시작
        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Bead[]> q = new LinkedList<>();
        q.add(new Bead[] { red, blue });
        int size = 1;
        int turn = 1;

        while (!q.isEmpty()) {
            for (int i = 0; i < size; i++) {
                Bead[] curr = q.poll();

                for (int dir = 0; dir < 4; dir++) {

                    // ---------------------------
                    // (1) "누가 먼저 이동할지" 결정
                    // ---------------------------
                    //   위(0) / 아래(1) / 왼(2) / 오른(3)
                    //   -> 방향별로 R과 B 중 먼저 굴릴 구슬을 결정
                    Bead first, second;
                    Bead fCopy, sCopy; // 이동 결과를 받을 임시 변수

                    // 빨간: curr[0], 파란: curr[1]
                    // dir == 0 : 위
                    if (dir == 0) { 
                        if (curr[0].r < curr[1].r) {
                            first = curr[0]; // 더 위인 구슬
                            second = curr[1];
                        } else {
                            first = curr[1];
                            second = curr[0];
                        }
                    }
                    // dir == 1 : 아래
                    else if (dir == 1) {
                        if (curr[0].r > curr[1].r) {
                            first = curr[0]; // 더 아래인 구슬
                            second = curr[1];
                        } else {
                            first = curr[1];
                            second = curr[0];
                        }
                    }
                    // dir == 2 : 왼
                    else if (dir == 2) {
                        if (curr[0].c < curr[1].c) {
                            first = curr[0];
                            second = curr[1];
                        } else {
                            first = curr[1];
                            second = curr[0];
                        }
                    }
                    // dir == 3 : 오른
                    else {
                        if (curr[0].c > curr[1].c) {
                            first = curr[0];
                            second = curr[1];
                        } else {
                            first = curr[1];
                            second = curr[0];
                        }
                    }

                    // 먼저 이동할 구슬
                    fCopy = moveBead(dir, first);
                    // 그 다음 이동할 구슬
                    //   - "먼저 이동해 멈춘 구슬"의 위치를 잠시 벽으로 간주하는 코드는
                    //     최소 수정만 고려해서 생략했지만,
                    //     실제로는 여기서 fCopy 위치를 막아 주어야 '통과'를 방지 가능
                    sCopy = moveBead(dir, second);

                    // fCopy와 sCopy를 다시 빨간, 파란 순서(newBeads[0], newBeads[1])로 매핑
                    Bead[] newBeads = new Bead[2];
                    // first가 원래 빨간이었으면 newBeads[0] = fCopy
                    //                   파란이었으면 newBeads[1] = fCopy
                    if (first == curr[0]) {
                        newBeads[0] = fCopy; 
                        newBeads[1] = sCopy;
                    } else {
                        newBeads[0] = sCopy;
                        newBeads[1] = fCopy;
                    }

                    // ---------------------------
                    // (2) 이동 끝난 후 처리
                    // ---------------------------
                    // 두 구슬이 겹치는 경우 처리
                    if (newBeads[0].r == newBeads[1].r && newBeads[0].c == newBeads[1].c) {
                        // 만약 그 위치가 구멍이라면(둘 다 빠진 상황)
                        // 문제 조건상 "파란 구슬이 빠지면 실패"이므로 continue
                        if (newBeads[0].r == hole[0] && newBeads[0].c == hole[1]) {
                            continue;
                        }
                        // 구멍이 아닐 때, move 값 비교해서 한 칸 뒤로
                        if (newBeads[0].move < newBeads[1].move) {
                            newBeads[1].r -= dr[dir];
                            newBeads[1].c -= dc[dir];
                        } else {
                            newBeads[0].r -= dr[dir];
                            newBeads[0].c -= dc[dir];
                        }
                    } 
                    else {
                        // 빨간 구슬 구멍 체크
                        if (newBeads[0].r == hole[0] && newBeads[0].c == hole[1]) {
                            return turn;
                        }
                        // 파란 구슬 구멍 체크 (newBeads[1]로 봐야 함!)
                        if (newBeads[1].r == hole[0] && newBeads[1].c == hole[1]) {
                            // 파란 구슬이 빠지면 실패
                            continue;
                        }
                    }

                    // 큐에 삽입
                    newBeads[0].move = 0;
                    newBeads[1].move = 0;
                    newBeads[0].beforeDir = dir;
                    newBeads[1].beforeDir = dir;
                    q.add(newBeads);
                }
            }

            size = q.size();
            turn += 1;
            if (turn > 10) return -1;
        }
        return -10;
    }

    // moveRedBead와 moveBlueBead를 하나로 합쳤습니다(같은 로직이므로)
    private static Bead moveBead(int dir, Bead bead) {
        Bead newBead = new Bead(bead.r, bead.c, bead.move, bead.beforeDir);

        int nr = newBead.r + dr[dir];
        int nc = newBead.c + dc[dir];
        while (true) {
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#') {
                return newBead;
            }
            if (map[nr][nc] == 'O') {
                newBead.r = nr;
                newBead.c = nc;
                return newBead;
            }
            newBead.r = nr;
            newBead.c = nc;
            newBead.move++;
            nr = newBead.r + dr[dir];
            nc = newBead.c + dc[dir];
        }
    }

    // 구슬과 구멍 위치 확인
    private static void findObjects() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 'R') {
                    red.r = r;
                    red.c = c;
                    map[r][c] = '.';
                } else if (map[r][c] == 'B') {
                    blue.r = r;
                    blue.c = c;
                    map[r][c] = '.';
                } else if (map[r][c] == 'O') {
                    hole[0] = r;
                    hole[1] = c;
                }
            }
        }
    }
}
