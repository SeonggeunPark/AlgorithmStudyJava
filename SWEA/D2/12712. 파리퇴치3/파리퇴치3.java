import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int nr, nc;
	// 십자 분사 상, 하, 좌, 우
	static int[] dr1 = { -1, 1, 0, 0 };
	static int[] dc1 = { 0, 0, -1, 1 };
	// 엑스자 분사 우상 우하 좌하 좌상
	static int[] dr2 = { -1, 1, 1, -1 };
	static int[] dc2 = { 1, 1, -1, -1 };
	// 맵 크기, 스프레이 세기
	static int N, M;
	// 파리 퇴치 최대값 저장
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			// N입력받아 N*N맵 생성
			N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			// 스프레이 세기 입력
			M = Integer.parseInt(st.nextToken());
			// map에 파리 수 입력
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 탐색 시작
			max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sprayPlus(map, r, c);
					sprayX(map, r, c);
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

	static void sprayPlus(int[][] map, int r, int c) {
		int sum = map[r][c];

		for (int i = 0; i < 4; i++) {
			for (int m = 1; m <= M-1; m++) {
				nr = r + dr1[i]*m;
				nc = c + dc1[i]*m;
				if (0 > nr || nr >= N || 0 > nc || nc >= N)
					continue;
				sum += map[nr][nc];
			}
		}
		
//		System.out.println(r+","+c+" "+sum);
		max = Math.max(max, sum);
	}

	static void sprayX(int[][] map, int r, int c) {
		int sum = map[r][c];

		for (int i = 0; i < 4; i++) {
			for (int m = 1; m <= M-1; m++) {
				nr = r + dr2[i]*m;
				nc = c + dc2[i]*m;
				if (0 > nr || nr >= N || 0 > nc || nc >= N)
					continue;
				sum += map[nr][nc];
			}
		}
		
//		System.out.println(r+","+c+" "+sum);
		max = Math.max(max, sum);
	}

}
