import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	// 말 이동 경우의 수
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] hdr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hdc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	// 맵
	static int[][] map;
	// 방문배열 (말처럼 이동한 횟수별로 관리)
	// [행][열][말처럼 이동한 횟수]
	static int[][] visited;
	static int K, H, W, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine()); // 말처럼 이동할 수 있는 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 맵 가로길이
		H = Integer.parseInt(st.nextToken()); // 맵 세로길이
		min = -1;

		map = new int[H][W];
		visited = new int[H][W];
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				visited[h][w] = -1;
			}
		}
		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}

		BFS();

		System.out.println(min);
	}

	static class Node {
		int r;
		int c;
		int k;

		public Node(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", k=" + k + "]";
		}
		
	}

	private static void BFS() {
		int cnt = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 0));
		visited[0][0] = 0; // 큐에 시작 노드 삽입 & 방문 체크
		int size = 1;

		while (!q.isEmpty()) {
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
//				System.out.println("현재 노드: " + curr);
				// 종착지 도착 시 종료
				if (curr.r == H - 1 && curr.c == W - 1) {
					min = cnt;
					return;
				}

				// 말처럼 이동할 수 있는 횟수 아직 남아있으면 이동
				if (curr.k < K) {
					for (int d = 0; d < 8; d++) {
						int nr = curr.r + hdr[d];
						int nc = curr.c + hdc[d];

						// 지도 범위 초과하면 pass
						if (nr < 0 || nr >= H || nc < 0 || nc >= W)
							continue;
						// 이미 방문했으면서 말처럼 이동할 수 있는 횟수가 현재 자신보다 낮으면 PASS
						if (visited[nr][nc] > -1 && visited[nr][nc] <= curr.k+1)
							continue;
						// 장애물이 있으면 pass
						if (map[nr][nc] == 1)
							continue;

						// 큐 삽입 & 방문 체크
						visited[nr][nc] = curr.k+1;
						q.offer(new Node(nr, nc, curr.k + 1));
						
					}
				}
				// 기본 이동
				for (int d = 0; d < 4; d++) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];

					// 지도 범위 초과하면 pass
					if (nr < 0 || nr >= H || nc < 0 || nc >= W)
						continue;
					// 이미 방문했으면서 말처럼 이동할 수 있는 횟수가 현재 자신보다 낮으면 PASS
					if (visited[nr][nc] > -1 && visited[nr][nc] <= curr.k)
						continue;
					// 장애물이 있으면 pass
					if (map[nr][nc] == 1)
						continue;

					// 큐 삽입 & 방문 체크
					visited[nr][nc] = curr.k;
					q.offer(new Node(nr, nc, curr.k));
				}
			}
			size = q.size();
			cnt += 1;
		}
	}
}