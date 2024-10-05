import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * BFS
 * 큐에 좌표랑 chance까지 같이 넣고?
 * 벽이면 벽 부수는 걸 큐에 넣기?
 */
public class Main {
	static int N, M, K;
	static char[][] map;
	static int[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
//		K=1;

		map = new char[N][M];
		visited = new int[N][M][K + 1];

		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		ans = -1;
		BFS(0, 0);

		System.out.println(ans);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j, K });
		visited[i][j][K] = 1;

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			// 목적지면 종료
			if (pos[0] == N - 1 && pos[1] == M - 1) {
				ans = visited[N - 1][M - 1][pos[2]];
				return;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = pos[0] + dr[dir];
				int nc = pos[1] + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
//				if (visited[nr][nc][pos[2]]>0)
//					continue;
				if (map[nr][nc] == '1') {
					if (pos[2] > 0) {
						if (visited[nr][nc][pos[2] - 1] > 0)
							continue;
						q.add(new int[] { nr, nc, pos[2] - 1 });
						visited[nr][nc][pos[2] - 1] = visited[pos[0]][pos[1]][pos[2]] + 1;
					}
				} else {
					if (visited[nr][nc][pos[2]] > 0)
						continue;
					q.add(new int[] { nr, nc, pos[2] });
					visited[nr][nc][pos[2]] = visited[pos[0]][pos[1]][pos[2]] + 1;
				}

			}
		}

	}
}
