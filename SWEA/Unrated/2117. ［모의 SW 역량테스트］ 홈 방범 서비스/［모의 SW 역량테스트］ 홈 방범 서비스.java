import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static boolean[][] map;
	static int[] diamondK;
	static int maxIncome, maxCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new boolean[N][N];
			
			// 지도 상황 배열 입력
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					if (Integer.parseInt(st.nextToken()) == 1)
						map[r][c] = true;
				}
			}
			// k=1일 때 최소 이윤이 보장되므로 이윤과 집 개수 변수 저장
			maxIncome = M - 1;
			maxCnt = 1;
			
			// 0, 0부터 탐색하며 모든 경우의 수 구함
			// k=2부터 N+1까지 모두 구하여 이윤이 0 이상이면서 cnt가 가장 많은 것 저장
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int k = 2; k <= N+1; k++) {
						diamondSearch(r, c, k);
					}
				}
			}
			System.out.println("#"+t+" "+maxCnt);

		}

	}

	// 마름모 모양으로 k 크기만큼 탐색
	static void diamondSearch(int r, int c, int k) {
		int cnt = 0;
		// i: 행 j, 열
		for (int i = r - k + 1; i <= r + k - 1; i++) {
			// i행이 배열 범위 벗어나면 continue
			if (0 > i || i >= N)
				continue;
			// 중심 행과의 거리
			int dFromMid = Math.abs(r - i);
			// i행 c열에 집이 있으면 cnt + 1
			if (map[i][c]==true)
				cnt++;
			// c열부터 중심 행과의 거리에 따라 양 옆 집 탐색
			for (int j = 1; j < k - dFromMid; j++) {
				if (c + j < N && map[i][c + j])
					cnt++;
				if (0 <= c - j && map[i][c - j])
					cnt++;
			}
		}
		// 이윤 산출
		int income = cnt * M - (k * k + (k - 1) * (k - 1));
		// 이윤이 0이상이면서 최대 카운트인것 저장
		if (income >= 0) {
			if (cnt > maxCnt) {
				maxCnt = cnt;
			}
		}
	}
}