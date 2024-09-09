import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 맵 배열 입력
		map = new char[N][M];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		min = N * M + 1;
//		visited = new boolean[N][M];
//		visited[0][0] = true;
//		dfs(0, 0, 1, true);
		visited = new int[N][M][2];
//		if (min == N * M + 1)
//			min = -1;
		
//		System.out.println(min);
		
		System.out.println(bfs(0, 0));
	}

	static int min;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		// r좌표, c좌표, 이동거리, 벽 부순 여부
		q.add(new int[] { 0, 0, 1, 0 });
		// 방문체크
		visited[0][0][0] = 1;

		while (!q.isEmpty()) {
			// 큐에서 뽑기
			int[] curr = q.poll();
			// 종점 도착 시 종료
			if (curr[0] == N - 1 && curr[1] == M - 1)
				return curr[2];
			// 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				// 범위 벗어나으면 패스
				if (0 > nr || N <= nr || 0 > nc || M <= nc)
					continue;
				// (1) 벽일 때 기회 남아있으면 기회 차감하고 큐에 삽입 / 기회 없으면 패스
				if (map[nr][nc] == '1') {
					if (curr[3]==0 && visited[nr][nc][1] == 0) {
						visited[nr][nc][1] = curr[2] + 1;
						q.add(new int[] { nr, nc, curr[2] + 1 , 1});
//						continue;
					}
				}
				// (2) 0이면 그냥 큐에 삽입
				else {
					if (visited[nr][nc][curr[3]] == 0) {
						visited[nr][nc][curr[3]] = curr[2] + 1;
						q.add(new int[] { nr, nc, curr[2] + 1, curr[3]});
					}
				}
			}
		}
		return -1;
	}
}
