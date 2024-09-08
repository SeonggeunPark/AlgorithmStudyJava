import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  기본적으로 완전탐색 방법 사용
 *  약품 주입 횟수를 1개씩 늘려가며 확인.
 *  약품 주입 위치는 1번 행부터 N번째 행까지 순차적으로 완전탐색하며 확인
 */
public class Solution {
	static int D, W, K;
	static boolean[][] films;
	static boolean[][] tFilms;
	static boolean[][] fFilms;
	static int injectionTimes;
	static boolean isPass;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			films = new boolean[D][W];
			// 약품 주입 시 스왑할 true, false로 초기화된 배열 생성
			fFilms = new boolean[D][W];
			tFilms = new boolean[D][W];
			// 필름 배열 입력 (true: B, false: A)
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					tFilms[r][c] = true;
					if (Integer.parseInt(st.nextToken()) == 1) {
						films[r][c] = true;
					}
				}
			}
			injectionTimes = K;
			isPass = false;
			// 약품주입횟수 0회부터 늘려가며 합격 여부 확인
			for (int i=0; i<=K; i++) {
				injection(i, 0);
				if(isPass) {
					injectionTimes = i;
					break;
				}
			}

			System.out.println("#" + t + " " + injectionTimes);
		}
	}

	// 성능검사 통과 여부를 확인하는 메서드
	static boolean checkPerformance() {
		out: for (int c = 0; c < W; c++) {
			for (int r = 0; r < D - K + 1; r++) {
				int tCnt = 0;
				int fCnt = 0;
				for (int i = r; i < r + K; i++) {
					if (films[i][c])
						tCnt++;
					if (!films[i][c])
						fCnt++;
				}
				if (tCnt == 0 || fCnt == 0)
					continue out;
			}
			return false;
		}
		return true;
	}

	// 약품 주입횟수별 약품 주입 하는 모든 경우의 수 생성하는 메서드
	static void injection(int injTime, int idx) {
		// 약품주입횟수가 모두 채워지면 성능검사
		if (injTime == 0) {
//			for (int i = 0; i < D; i++) {
//				System.out.println(Arrays.toString(films[i]));
//			}
//			System.out.println();
			if (checkPerformance()) {
				isPass = true;
			}
			return;
		}
		// 약품주입횟수를 채우지 않고 종료되었다면 그냥 리턴
		if (idx >= D) {
			return;
		}

		// 해당 행에 약품 주입 O (B타입)
		tswap(idx); // 모두 true인 행과 스왑
		injection(injTime - 1, idx + 1);
		tswap(idx); // 원상복구
		// 해당 행에 약품 주입 O (A타입)
		fswap(idx); // 모두 false인 행과 스왑
		injection(injTime - 1, idx + 1);
		fswap(idx); // 원상복구
		// 해당 행 약품 주입 X
		injection(injTime, idx + 1);
	}

	static void tswap(int rowNum) {
		boolean[] tmp = films[rowNum];
		films[rowNum] = tFilms[rowNum];
		tFilms[rowNum] = tmp;
	}

	static void fswap(int rowNum) {
		boolean[] tmp = films[rowNum];
		films[rowNum] = fFilms[rowNum];
		fFilms[rowNum] = tmp;
	}
}
