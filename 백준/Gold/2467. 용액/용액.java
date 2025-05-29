import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		// 모두 음수거나 양수면 0과 가장 가까운 두 용액을 출력
		if (arr[0] <= 0 && arr[N - 1] <= 0) {
			sb.append(arr[N - 2]).append(' ').append(arr[N - 1]);
			System.out.println(sb);
			return;
		}
		if (arr[0] >= 0 && arr[1] >= 0) {
			sb.append(arr[0]).append(' ').append(arr[1]);
			System.out.println(sb);
			return;
		}

		int l = 0;
		int r = N-1;
		int ansL = 0;
		int ansR = N-1;
		
		while(l < r) {
			int sum = arr[l] + arr[r];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				ansL = l;
				ansR = r;
			}
			if (sum < 0) {
				l++;
			} else {
				r--;
			}
		}
		
		sb.append(arr[ansL]).append(' ').append(arr[ansR]);
		System.out.println(sb);
	}

	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int c = 0; c < N; c++) {
			arr[c] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
	}
}