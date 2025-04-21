import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine()); // 수열 크기
		int[] arr = new int[L];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int S = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		// S가 포함되면 좋은 구간 없음
		for (int i = 0; i < L; i++) {
			if (arr[i] == S) {
				System.out.println(0);
				return;
			}
		}

		// S보다 작은 수 중 가장 큰 수 (start), 큰 수 중 가장 작은 수 (end)
		int start = 0;
		int end = 1001;

		for (int i = 0; i < L; i++) {
			if (arr[i] < S) {
				start = Math.max(start, arr[i]);
			} else if (arr[i] > S) {
				end = Math.min(end, arr[i]);
			}
		}

		int result = (S - start) * (end - S) - 1;
		System.out.println(result);
	}
}
