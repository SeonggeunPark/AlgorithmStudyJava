import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 문제를 잘못 읽고 단순 사방 탐색만 했으나,
*  가운데 들어있는 꽃가루 수만큼 상하좌우로 더 이동하면 되기에
*  for문을 겉에 하나 더 추가하여 해결하였다.
*/
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int nr, nc;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] balloons = new int[N][M];

			// 풍선 맵 입력
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					balloons[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			int sum;

			// 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					sum = 0;
					sum += balloons[r][c];
					for (int j = 1; j <= balloons[r][c]; j++) {
						for (int i = 0; i < 4; i++) {
							nr = r + dr[i]*j;
							nc = c + dc[i]*j;
							if (0 <= nr && nr < N && 0 <= nc && nc < M) {
								sum += balloons[nr][nc];
							}
						}
					}
					max = Math.max(max, sum);
				}
			}

			System.out.println("#" + t + " " + max);
		}

	}

}
