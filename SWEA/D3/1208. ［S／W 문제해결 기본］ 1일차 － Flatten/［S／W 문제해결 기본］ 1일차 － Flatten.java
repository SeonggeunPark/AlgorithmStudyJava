import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 모든 회차마다 가장 높은 곳에서 빼고 가장 낮은 곳에 올려야 하므로
 * 반복문을 이용해 매 회 시뮬레이션해주어야 한다.
 * 오름차순 정렬한 후 가장 낮은 lowest 지점과 highest지점을 잡고
 * 회마다 조정해가며 답을 구함.
 */

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());

			// 가로길이 100인 배열 생성
			int[] arr = new int[100];
			st = new StringTokenizer(br.readLine());
			// 배열 입력
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 오름차순 정렬
			Arrays.sort(arr);

			// start는 항상 가장 값이 낮은 인덱스를 가리키고,
			// end는 항상 가장 값이 높은 인덱스를 가리켜야 한다.
			int lowest = 0;
			int highest = 99;
			while (arr[highest] - arr[lowest] > 1) {
				// (1)큰 쪽에서 하나 꺼내기
				// 왼쪽 값보다 클 땐 해당 값 내리고 end = 99 초기화
				if (arr[highest] > arr[highest - 1]) {
					arr[highest] -= 1;
					highest = 99;
				} else {
					arr[highest] -= 1;
					highest -= 1;
				}
				// (2)낮은 쪽에 올리기
				// 오른쪽 값보다 작을 땐 해당 값 올리고 start=0 초기화
				if (arr[lowest] < arr[lowest + 1]) {
					arr[lowest] += 1;
					lowest = 0;
					// 두 값이 같으면 현재 값 올리고 start를 오른쪽으로 옮김
				} else {
					arr[lowest] += 1;
					lowest += 1;
				}

				// (3) 남은 횟수 1개 줄이기
				N--;
				if (N==0) break;
			}

			System.out.println("#" + t + " " + (arr[highest] - arr[lowest]));
		}

	}
}
