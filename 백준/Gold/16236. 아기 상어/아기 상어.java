import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N;
	// 0: r, 1: c, 2: 크기, 3: 먹은 물고기 수
	static int[] shark = new int[4];
	// 0: r, 1: c, 2: 크기, 3: 물고기 리스트 index
	static int[] target = new int[4];
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]>[] fishes;

	public static void main(String[] args) throws IOException {
		init();

		System.out.println(simulation());
	}

	// 시뮬레이션
	private static int simulation() {
		int time = 0;

		while (true) {
			// 가장 가까운 타겟 선택
			// => 상어보다 크기 작으면서 가장 가까운 물고기
			Arrays.fill(target, 0);
			int min = 401;
			for (int i = 1; i < shark[2] && i < 7; i++) {
				for (int j=0; j<fishes[i].size(); j++) {
					int[] fish = fishes[i].get(j);
					int timeTaken = bfs(fish[0], fish[1]);
					if (timeTaken <= min) {
						if (timeTaken == min) {
							if (target[0] < fish[0])
								continue;
							else if (target[0] == fish[0]) {
								if (target[1] < fish[1])
									continue;
							}
						}
						target[0] = fish[0];
						target[1] = fish[1];
						target[2] = i;
						target[3] = j;
						min = timeTaken;
					}
				}
			}
			
			// 타겟이 없으면 종료
			if (target[2] <= 0) {
				return time;
			}

			// 타겟 있으면 해당 위치 이동 후 시간 가산
			// 물고기 먹기
			shark[3] += 1;
			fishes[target[2]].remove(target[3]);
			// 상어 위치 이동
			map[shark[0]][shark[1]] = 0;
			map[target[0]][target[1]] = 9;
			shark[0] = target[0];
			shark[1] = target[1];
			// 상어 크기 조정
			if (shark[3] >= shark[2]) {
				shark[2] += 1;
				shark[3] = 0;
			}
			// 시간 가산
			time += min;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static int bfs(int targetR, int targetC) {
		visited = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<>();
		// 시작지점 큐에 삽입 & 방문체크
		q.offer(new int[] { shark[0], shark[1] });
		visited[shark[0]][shark[1]] = true;

		int size = 1;
		int cnt = 0;

		while (!q.isEmpty()) {
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				// 목표지점 도착 시 종료
				if (curr[0] == targetR && curr[1] == targetC) {
					return cnt;
				}
				// 사방탐색
				for (int dir = 0; dir < 4; dir++) {
					int nr = curr[0] + dr[dir];
					int nc = curr[1] + dc[dir];

					// 이미 방문했거나, 범위 밖이거나, 상어보다 크기가 큰 물고기면 패스
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					if (visited[nr][nc])
						continue;
					if (map[nr][nc] > shark[2])
						continue;

					q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
			cnt += 1;
			size = q.size();
		}
		return Integer.MAX_VALUE;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		// 물고기 크기별 좌표값 저장 배열
		fishes = new ArrayList[7];
		for (int i = 1; i <= 6; i++) {
			fishes[i] = new ArrayList<>();
		}

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int n = Integer.parseInt(st.nextToken());
				map[r][c] = n;

				if (1 <= n && n <= 6) {
					fishes[n].add(new int[] { r, c });
				}
				if (n == 9) {
					shark[0] = r;
					shark[1] = c;
					shark[2] = 2;
				}
			}
		}
	}
}
