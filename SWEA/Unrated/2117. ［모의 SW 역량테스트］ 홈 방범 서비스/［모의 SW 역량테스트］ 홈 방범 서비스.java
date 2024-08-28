import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
//			for (int r=0; r<N; r++) {
//				System.out.println(Arrays.toString(map[r]));
//			}
			// k=1일 때 이윤
			maxIncome = M - 1;
			maxCnt = 1;
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
		for (int i = r - k + 1; i <= r + k - 1; i++) {
			if (0 > i || i >= N)
				continue;
			int dFromMid = Math.abs(r - i);
			if (map[i][c]==true)
				cnt++;
//				System.out.printf("dfromMid: %d, %d, %d : true\n",dFromMid, i, c);
			for (int j = 1; j < k - dFromMid; j++) {
				if (c + j < N && map[i][c + j])
					cnt++;
//				System.out.printf("%d, %d\n",i, c+j);
				if (0 <= c - j && map[i][c - j])
					cnt++;
//				System.out.printf("%d, %d\n",i, c-j);
			}
		}
		// 이윤 산출
		int income = cnt * M - (k * k + (k - 1) * (k - 1));
//		System.out.printf("좌표: %d, %d   k: %d  %d %d\n",r, c, k, cnt, income);
		if (income >= 0) {
			if (cnt > maxCnt) {
				maxCnt = cnt;
			}
		}
	}
}