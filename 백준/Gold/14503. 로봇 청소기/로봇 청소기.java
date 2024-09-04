import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] map;
	static boolean[][] visited;
	static int N, M;
	static int d;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		visited = new boolean[N][M];
		cnt = 0;

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		// 지도 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = true;
					visited[i][j] = true;
					;
				}
			}
		}
		// 작업시작
		dfs(r, c, d);

		// 출력
		System.out.println(cnt);

	}

	static void dfs(int i, int j, int d) {
		// 1. 현재칸이 아직 청소되지 않은 경우, 현재 칸 청소
		if (!visited[i][j]) {
			visited[i][j] = true;
			cnt++;
		}
//		for (int n = 0; n < N; n++) {
//			System.out.println(Arrays.toString(visited[n]));
//		}
//		System.out.println();
		boolean isEmpty = false;
		// 빈 공간 확인 배열
		boolean[] canGo = new boolean[4];

		// 2. 주변 간 탐색
		for (int idx = 0; idx < 4; idx++) {
			int nr = i + dr[idx];
			int nc = j + dc[idx];
			// 배열 범위 안벗어나고 & 청소를 안했고 & 벽이 아니면 빈공간 확인 배열에 기록
			if (0 <= nr && nr < N && 0 <= nc && nc < M && !map[nr][nc] && !visited[nr][nc]) {
				isEmpty = true;
				canGo[idx] = true;
			}
		}
		// 2-1) 빈 곳이 있으면 반시계 회전
		if (isEmpty) {
			for (int n = 0; n < 4; n++) {
				d = (d + 3) % 4;
				// 앞쪽 칸 이동 가능하면 이동
				if (canGo[d]) {
					dfs(i + dr[d], j + dc[d], d);
					return;
				}
			}
			// 2-2) 빈 곳이 없으면 후진
		} else {
			// 뒤칸 확인
			int nr = i - dr[d];
			int nc = j - dc[d];
			// 배열 범위 벗어나는지 & 빈칸인지 확인
			if (0 <= nr && nr < N && 0 <= nc && nc < M && !map[nr][nc]) {
				dfs(nr, nc, d);
			} else
				return;
		}
	}
}
