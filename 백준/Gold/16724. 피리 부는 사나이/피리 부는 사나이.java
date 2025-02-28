import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 모든 칸에서 경로 탐색하면서 사이클 나오면 visited 체크해서 1개로 퉁치기?
 */
public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, cnt;
	static char[][] map;
	static int[][] visited;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new int[N][M];
		cnt = 0;

		// 지도 입력
		map = new char[N][M];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (visited[r][c] > 0)
					continue;
				visited[r][c] += 1;
				DFS(r, c);
				cnt += 1;
			}
		}

//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < M; c++) {
//				System.out.print(visited[r][c] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(cnt);
	}

	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			// 4방 탐색
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] > 0)
					continue;
				
				// 방향에 따라 다르게 반응
				if (dir == 0 && map[nr][nc] == 'D') {
					visited[nr][nc] += 1;
					q.add(new int[] { nr, nc });
				} else if (dir == 1 && map[nr][nc] == 'U') {
					visited[nr][nc] += 1;
					q.add(new int[] { nr, nc });
				} else if (dir == 2 && map[nr][nc] == 'R') {
					visited[nr][nc] += 1;
					q.add(new int[] { nr, nc });
				} else if (dir == 3 && map[nr][nc] == 'L') {
					visited[nr][nc] += 1;
					q.add(new int[] { nr, nc });
				}
			}
		}

	}
	private static void DFS(int r, int c) {

		// 날 향하는 칸들 모두 체크
		BFS(r, c);
		
		int nr = r;
		int nc = c;
		switch (map[r][c]) {
			case 'U': {
				nr += dr[0];
				nc += dc[0];
				break;
			}
			case 'D': {
				nr += dr[1];
				nc += dc[1];
				break;
			}
			case 'L': {
				nr += dr[2];
				nc += dc[2];
				break;
			}
			case 'R': {
				nr += dr[3];
				nc += dc[3];
				break;
			}
			default:
				break;
			}
		
		if (visited[nr][nc] > 0) { 
			return;
		}
		
		visited[nr][nc] += 1;
		DFS(nr, nc);
	}
}
