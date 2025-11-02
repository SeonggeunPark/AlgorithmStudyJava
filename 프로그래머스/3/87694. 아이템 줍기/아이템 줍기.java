import java.util.*;

class Solution {
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		// 모든 칸을 -1로
		int[][] map = new int[101][101];
		for (int x = 0; x <= 100; x++) {
			Arrays.fill(map[x], -1);
		}
		// 사각형 순회하며 처리
		for (int i = 0; i < rectangle.length; i++) {
			int x1 = rectangle[i][0] * 2;
			int y1 = rectangle[i][1] * 2;
			int x2 = rectangle[i][2] * 2;
			int y2 = rectangle[i][3] * 2;

			for (int x = x1; x <= x2; x++) {
				for (int y = y1; y <= y2; y++) {
					// 테두리일때
					if (x == x1 || x == x2 || y == y1 || y == y2) {
						if (map[x][y] != 0) {
							map[x][y] = 1;
						}
						// 안쪽일 때
					} else {
						map[x][y] = 0;
					}
				}
			}
		}

		// 테두리 중 갈 수 없는 곳 false 처리
		return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	private static int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;
		boolean[][] visited = new boolean[101][101];
		Queue<int[]> q = new ArrayDeque<>();

		visited[characterX][characterY] = true;
		q.offer(new int[] { characterX, characterY });

		int size = 1;
		while (!q.isEmpty()) {
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int curX = cur[0];
				int curY = cur[1];

				if (curX == itemX && curY == itemY) {
					System.out.println(answer/2);
					return answer / 2;
				}

				for (int dir = 0; dir < 4; dir++) {
					int nr = curX + dr[dir];
					int nc = curY + dc[dir];

					if (nr < 0 || nr > 100 || nc < 0 || nc > 100 || visited[nr][nc])
						continue;
					if (map[nr][nc] != 1)
						continue;

					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}

			answer += 1;
			size = q.size();
		}

		return answer / 2;
	}
}
