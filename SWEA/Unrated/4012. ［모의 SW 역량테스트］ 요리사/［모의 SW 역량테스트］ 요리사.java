import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] synergy;
	static int N;
	static int[] foodA, foodB;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			// 시너지 배열 입력
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					synergy[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 맛 차이 초기화
			min = 2100000000;
			// 음식 재료 배열 초기화
			foodA = new int[N / 2];
			foodB = new int[N / 2];

			Combination(0, 0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	// N개의 재료를 A, B요리에 반씩 나눠 담는 메서드
	static void Combination(int idx, int aidx, int bidx) {
		// 둘 중 하나가 다 차면 종료
		if (aidx >= N / 2 || bidx >= N / 2) {
			calDiff(idx, aidx, bidx);
			return;
		}
		if (idx >= N)
			return;
		// 해당 재료를 A 음식에 넣는다
		foodA[aidx] = idx;
		Combination(idx + 1, aidx + 1, bidx);

		// 해당 재료를 B 음식에 넣는다
		foodB[bidx] = idx;
		Combination(idx + 1, aidx, bidx + 1);
	}
	// 맛 차이를 계산하는 메서드
	// idx: 재료번호, aidx: A요리에 들어갈 재료번호, bidx: B요리에 들어갈 재료 번호
	static void calDiff(int idx, int aidx, int bidx) {
		// 아직 재료 덜 들어간 요리 찾아 나머지 재료를 넣음
		if (aidx > bidx) {
			// A에 안들어간 재료는 B 배열에 담음
			for (int i = idx; i < N; i++) {
				foodB[bidx++] = i;
			}
		} else {
			// B에 안들어간 재료는 A 배열에 담음
			for (int i = idx; i < N; i++) {
				foodA[aidx++] = i;
			}
		}

		// 각 맛 점수를 계산
		int tasteA = calTaste(foodA);
		int tasteB = calTaste(foodB);

		min = Math.min(Math.abs(tasteA - tasteB), min);
	}
	// 맛 점수를 계산하는 메서드
	static int calTaste(int[] arr) {
		// 맛 점수 저장할 변수
		int taste = 0;
		// 배열 안의 재료 중 2개를 뽑는 모든 경우의 수 시너지 계산
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				taste += synergy[arr[i]][arr[j]] + synergy[arr[j]][arr[i]];
			}
		}
		
		return taste;
	}
}
