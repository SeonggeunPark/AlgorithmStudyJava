import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int max, cnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		init();   // 변수 선언 및 초기화 메서드
		
		search(); // 모든 맵을 탐색하며 넓이와 개수 계산
		
		print(cnt, max); // 출력 메서드
	}
	// 변수 선언 및 초기화 메서드
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}
	// 모든 맵을 탐색하며 넓이와 개수 계산
	private static void search() {
		cnt = 0;
		max = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 값이 1이면서 아직 방문 안했으면 BFS 탐색
				if (map[r][c] == 1) {
					BFS(r, c);
					cnt += 1;
				}
			}
		}
	}
	// BFS 탐색 메서드
	static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		int tmpMax = 1; // 넓이 1부터 시작
		map[r][c] = 0; // 시작점 0으로 변경
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0)
					continue;

				q.add(new int[] { nr, nc });
				tmpMax += 1;
				map[nr][nc] = 0;
			}
		}

		max = Math.max(tmpMax, max);
	}
	// 출력 메서드
	private static void print(int cnt, int max) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(cnt).append('\n').append(max);
		
		System.out.println(sb);
	}
}
