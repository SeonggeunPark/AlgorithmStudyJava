import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        // map 입력
        String str;
        for (int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        
        visited = new boolean[N][M];
        
        BFS();
        
        System.out.println(map[N-1][M-1]);
        
    }
        
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int nr, nc;
    static ArrayList<Integer> pos, npos; // 큐에 담을 좌표값 선언
    static int count = 0;

    static void BFS() {
        Queue<ArrayList> queue = new LinkedList<>();

        if (visited[0][0])
            return;

        pos = new ArrayList<>();
        pos.add(0);
        pos.add(0);

        queue.offer(pos);
        visited[0][0] = true;
        while (visited[visited.length - 1][visited[0].length - 1] == false) {
            pos = queue.poll(); // (1)

            for (int idx = 0; idx < 4; idx++) {
                npos = new ArrayList<>();

                nr = pos.get(0) + dr[idx];
                nc = pos.get(1) + dc[idx];

                if (0 <= nr && nr < map.length && 0 <= nc && nc < map[0].length && map[nr][nc] == 1
						&& visited[nr][nc] == false) {

                    npos.add(nr);
                    npos.add(nc);
                    queue.offer(npos); // (2)
                    visited[nr][nc] = true; // (3)
                    map[nr][nc] = map[pos.get(0)][pos.get(1)]+1;
                }
            }
        }
    }
}