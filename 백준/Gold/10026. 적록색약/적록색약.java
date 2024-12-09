import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n, cnt_b, cnt_nb;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visited_b;
	static boolean[][] visited_nb;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		for (int r = 0; r < n; r++) {
			map[r] = br.readLine().toCharArray();
		}

		visited_b = new boolean[n][n]; // 적록색약자 방문배열
		visited_nb = new boolean[n][n]; // 적록색약 아닌 자 방문배열

		cnt_b = 0; // 적록색약자 구역 수
		cnt_nb = 0; // 적록색약이 아닌 자 구역 수

		q = new LinkedList<>();
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (!visited_b[r][c]) {
					BFS_b(r, c);
					cnt_b += 1;
				}
				if (!visited_nb[r][c]) {
					BFS_nb(r, c);
					cnt_nb += 1;
				}
			}
		}

		System.out.println(cnt_nb +" "+ cnt_b);
	}

	// 적록색약자의 BFS 탐색
	private static void BFS_b(int r, int c) {
		// 큐 초기화
		q.clear();
		q.add(new int[] { r, c }); // 시작지점 큐에 삽입
		visited_b[r][c] = true; // 시작지점 방문체크

		while (!q.isEmpty()) {
			// 사방 탐색 후 거리저장 및 큐 삽입
			int[] curr = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];

				// 이미 방문했거나 범위 벗어나거나 갈 수 없는 땅이면 패스
				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				if (visited_b[nr][nc])
					continue;
				// 섹이 다른 경우 패스 (적록은 같은 색으로 간주)
				if (map[r][c] == 'R' || map[r][c] == 'G') {
					if (map[nr][nc] == 'B')
						continue;
				} else {
					if (map[nr][nc] != 'B')
						continue;
				}

				// 큐에 삽입 후 방문체크
				q.add(new int[] { nr, nc });
				visited_b[nr][nc] = true;
			}
		}
	}

	// 적록색약이 아닌 자의 BFS 탐색
	private static void BFS_nb(int r, int c) {
		// 큐 초기화
		q.clear();
		q.add(new int[] { r, c }); // 시작지점 큐에 삽입
		visited_nb[r][c] = true; // 시작지점 방문체크

		while (!q.isEmpty()) {
			// 사방 탐색 후 거리저장 및 큐 삽입
			int[] curr = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];

				// 이미 방문했거나 범위 벗어나거나 갈 수 없는 땅이면 패스
				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				if (visited_nb[nr][nc])
					continue;
				// 색이 다른 경우에도 패스
				if (map[nr][nc] != map[r][c])
					continue;

				// 큐에 삽입 후 방문체크
				q.add(new int[] { nr, nc });
				visited_nb[nr][nc] = true;
			}
		}
	}
}
