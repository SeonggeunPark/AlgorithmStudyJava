import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static class Node implements Comparable<Node> {
    		int r, c, w;

			public Node(int r, int c, int w) {
				super();
				this.r = r;
				this.c = c;
				this.w = w;
			}

			@Override
			public int compareTo(Main.Node o) {
				return o.w - this.w;
			}

			@Override
			public String toString() {
				return "[" + r + ", " + c + ", " + w + "]";
			}
    			
    }
    public static void main(String[] args) throws IOException {
        init();
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(0, 0, map[0][0]));
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
        		Node cur = pq.poll();
        		
        		// 현위치 경우의수 구하기
        		for (int d=0; d<4; d++) {
        			int nr = cur.r+dr[d];
        			int nc = cur.c+dc[d];
        			if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
        			if (map[cur.r][cur.c] >= map[nr][nc]) continue;
        			dp[cur.r][cur.c] += dp[nr][nc];
        		}
//        		System.out.println("현위치 : "+cur.r+", "+cur.c+"     dp : "+dp[cur.r][cur.c]);
        		
        		if (cur.r==N-1 && cur.c==M-1) {
        			break;
        		}
        		
        		// 갈 수 있는 곳 큐에 삽입
        		for (int d=0; d<4; d++) {
        			int nr = cur.r+dr[d];
        			int nc = cur.c+dc[d];
        			if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
        			if (map[cur.r][cur.c] <= map[nr][nc]) continue;
        			if (visited[nr][nc]) continue;
        			pq.offer(new Node(nr, nc, map[nr][nc]));
        			visited[nr][nc] = true;
        		}
        		
//        		System.out.println(pq);
        }
        
        System.out.println(dp[N-1][M-1]);
    }
    // 상, 좌, 하, 우 
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = { 0,-1, 0, 1};

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int r = 0; r < N; r++) {
        		st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
            		map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        dp[0][0] = 1;
        
    }
}
