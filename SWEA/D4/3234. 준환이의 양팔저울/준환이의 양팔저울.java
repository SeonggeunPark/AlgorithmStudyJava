import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine());

			// 배열에 숫자 담음
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int count = changeOrder(arr, 0, N);
			
			System.out.println("#" + t + " " + count);
		}
	}

	// 배열의 순서를 변경하고, 변경 완료하면 재귀함수 호출하는 메서드
	static int changeOrder(int[] arr, int idx, int N) {
		// 순서 변경 완료되면 재귀함수 작동
		if (idx == N) {
			return countCase(arr, 0, 0, 0, N);
		}

		// 재귀함수 동작 완료 후 경우의 수 저장할 변수
		int count = 0;

		// 첫번째 인덱스부터 변경
		for (int i = idx; i < N; i++) {
			swap(arr, idx, i);
			count += changeOrder(arr, idx + 1, N);
			swap(arr, idx, i);
		}
		
		// 재귀함수 수행 후 누적된 경우의 수 반환
		return count;
	}

	// 왼쪽 오른쪽 저울에 추를 올려가며 모든 경우의 수 탐색
	// 탐색 중 오른쪽 저울의 무게가 커지는 순간 해당 탐색은 종료
	// 모든 탐색 종료 후 왼쪽 저울 무게가 더 크면 1 반환 (count 1 추가)
	static int countCase(int[] arr, int idx, int lSum, int rSum, int N) {
		if (lSum < rSum) {
			return 0;
		}
		if (idx == N) {
			return lSum >= rSum ? 1 : 0;
		}
		int count = 0;
		// 왼, 오 탐색
		count += countCase(arr, idx + 1, lSum + arr[idx], rSum, N);
		count += countCase(arr, idx + 1, lSum, rSum + arr[idx], N);
		
		return count;
	}
	
	// 배열의 요소를 서로 변경하는 메서드
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
