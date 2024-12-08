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
	static int n, m, targetR, targetC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] ans;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		ans = new int[n][m];
		q = new LinkedList<>();

		targetR = -1;
		targetC = -1;
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				int n = Integer.parseInt(st.nextToken());
				map[r][c] = n;
				if (n == 2) {
					targetR = r;
					targetC = c;
				}
				ans[r][c] = -1;
			}
		}

		BFS(targetR, targetC);

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
                if (map[r][c] == 0) {  // 벽은 0으로 표시
                    sb.append(0).append(' ');
                } else {
                    sb.append(ans[r][c]).append(' ');
                }
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void BFS(int r, int c) {
		q.add(new int[] { r, c }); // 시작지점 큐에 삽입
		ans[r][c] = 0;

		while (!q.isEmpty()) {
			// 사방 탐색 후 거리저장 및 큐 삽입
			int[] curr = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];

				// 이미 방문했거나 범위 벗어나거나 갈 수 없는 땅이면 패스
				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if (ans[nr][nc] != -1)
					continue;
				if (map[nr][nc] == 0)
					continue;

				// 큐에 삽입 후 방문체크
				q.add(new int[] { nr, nc });
				ans[nr][nc] = ans[curr[0]][curr[1]]+1;
			}
		}
	}
}
