import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int w, h;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int[] dc = { 0, 0, -1, 1, 1, 1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt(); // 너비
			h = sc.nextInt(); // 높이
			if (w == 0 && h == 0)
				break;

			visited = new boolean[h][w];

			int cnt = 0;
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					int n = sc.nextInt();
					if (n == 1) {
						visited[r][c] = true;
					}
				}
			}

			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (visited[r][c]) {
//						BFS(r, c);
						DFS(r, c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void DFS(int r, int c) {
		visited[r][c] = false;

		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= h || nc < 0 || nc >= w || !visited[nr][nc])
				continue;

			DFS(nr, nc);
		}
	}

	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c });
		visited[r][c] = false;

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			int r1 = pos[0];
			int c1 = pos[1];

			for (int i = 0; i < 8; i++) {
				int nr = r1 + dr[i];
				int nc = c1 + dc[i];

				if (nr < 0 || nr >= h || nc < 0 || nc >= w || !visited[nr][nc])
					continue;

				q.add(new int[] { nr, nc });
				visited[nr][nc] = false;
			}
		}
	}
}
