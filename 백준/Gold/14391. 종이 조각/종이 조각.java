import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static int N, M, max;
	static char[][] map;
	static boolean[][] visited, directions; // false: 가로, true: 세로
	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		init();

		setMap(0, 0, 1);
		
		System.out.print(max);
	}

	private static void setMap(int r, int c, int cnt) {
		if (cnt > N * M) {
			int sum = calTotal();
			max = Math.max(max, sum);
			return;
		}
		directions[r][c] = true;
		if (c >= M - 1) {
			setMap(r + 1, 0, cnt + 1);
		} else {
			setMap(r, c + 1, cnt + 1);
		}

		directions[r][c] = false;
		if (c >= M - 1) {
			setMap(r + 1, 0, cnt + 1);
		} else {
			setMap(r, c + 1, cnt + 1);
		}
	}
	private static int calTotal() {
		visited = new boolean[N][M];
		int sum = 0;
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (visited[r][c]) continue;
				sum += Integer.parseInt(calLine(r, c, directions[r][c], ""));
			}
		}
		return sum;
	}
	private static String calLine(int r, int c, boolean direction, String num) {
		visited[r][c] = true;
		int dir = direction?1:0;
		int nr = r+dr[dir];
		int nc = c+dc[dir];
		if (nr >= N || nc >= M || visited[nr][nc] || directions[nr][nc] != direction) {
			return num+map[r][c];
		}
		return calLine(nr, nc, directions[nr][nc], num+map[r][c]);
	}
	private static void init() throws IOException {
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		directions = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}

		max = 0;
	}
}