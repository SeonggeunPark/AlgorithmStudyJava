import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		// 테스트케이스 시작
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N]; // 입력받은 수를 담는 배열
			List<Integer> danjo = new ArrayList<>(); // 앞뒤 숫자 곱을 담는 배열

			st = new StringTokenizer(br.readLine());

			// nums, danjo 배열 입력
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(nums);

			int mul;
			int max = -1;
			for (int i = N - 1; i >= 0; i--) {
				out: for (int j = i - 1; j >= 0; j--) {
					mul = nums[i] * nums[j];

					// 수의 오른쪽 자리부터 비교
					// (1) 1의자리 : 10으로 나눈 나머지 (mul%10)
					// (2) 10의자리 : 10으로 나누고 나서 10으로 나눈 나머지 ((mul/10) %10)
					while (mul / 10 > 0) {
						int low = mul % 10;
						mul = mul / 10;
						int high = mul % 10;

						if (low < high) {
							continue out;
						}
					}
					max = Math.max(max,  nums[i]*nums[j]);
				}


			}
			System.out.println("#" + t + " " + max);
		}
	}
}