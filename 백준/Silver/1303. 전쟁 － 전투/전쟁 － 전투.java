import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int Wpower, Bpower;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		init(); // 변수 선언 및 초기화 메서드

		// 맵에서 아직 방문하지 않은 구역 BFS 탐색
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (visited[r][c])
					continue;

				int n = BFS(r, c); // BFS탐색하여 인접하고 있는 같은 색의 개수를 반환

				if (map[r][c] == 'W') {
					Wpower += n * n;
				} else {
					Bpower += n * n;
				}
			}
		}

		System.out.println(Wpower + " " + Bpower); // 출력 메서드
	}

	private static int BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		visited[r][c] = true;
		q.add(new int[] { r, c });
		int cnt = 1;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc])
					continue;
				if (map[curr[0]][curr[1]] != map[nr][nc])
					continue;

				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				cnt += 1;
			}
		}

		return cnt;
	}

	// 변수 선언 및 초기화 메서드
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[M][N];
		visited = new boolean[M][N];

		for (int r = 0; r < M; r++) {
			map[r] = br.readLine().toCharArray();
		}

		Wpower = 0;
		Bpower = 0;
	}
}