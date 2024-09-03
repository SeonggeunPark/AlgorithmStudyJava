import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * visted를 활용한 DFS문제로, 배열의 모든 칸을 순회하며 방문한 칸은 방문 체크를 수행.
 * 방문하지 않은 구역만 DFS수행하면 DFS를 수행한 횟수가 곧 덩어리의 개수가 된다.
 * 
 * 첫 시도에서 테스트케이스 11개 중 10개만 맞음
 * => 최대 덩어리 개수를 0으로 초기화했으나, 결국 맨 처음 덩어리는 무조건 1개부터 시작하므로,
 * 	  maxCnt를 1로 초기화해야 함.
 */

public class Solution {
	static int[][] cheese;
	static int N;
	static int maxCnt;
	static int cnt;
	static boolean[][] visited;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int nr, nc;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// day의 최대치를 저장
			int maxDay = 0;
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			// 배열 입력
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					cheese[r][c] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, cheese[r][c]);
				}
			}
			// 최대 덩어리 개수를 저장할 변수 초기화
			maxCnt = 1;
			int day = 1;
			// 최대day부터는 남은 조각이 없으므로, 최대day-1 까지만 반복
			while (day <= maxDay - 1) {
				visited = new boolean[N][N];
				cnt = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						// 방문하지 않았으면서, day보다 큰 구역만 탐색 시작
						if (!visited[r][c] && cheese[r][c] > day) {
							visited[r][c] = true;
							DFS(r, c, day);
							// 한번 탐색할 때 한 덩어리를 모두 방문하므로, 탐색한 횟수가 곧 덩어리의 개수
							cnt++;
						}
					}
				}

				maxCnt = Math.max(maxCnt, cnt);
				day++;
			}

			System.out.println("#" + t + " " + maxCnt);
		}
	}

	static void DFS(int r, int c, int day) {
		// 방문처리
		visited[r][c] = true;

		// 사방탐색하여 DFS 가능한 구역으로 진출
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];

			if (0 <= nr && nr < N && 0 <= nc && nc < N // 배열 범위를 벗어나지 않고
					&& cheese[nr][nc] > day // day보다 크고
					&& !visited[nr][nc]) { // 방문하지 않았으면 OK
				DFS(nr, nc, day);
			}
		}
	}
}
