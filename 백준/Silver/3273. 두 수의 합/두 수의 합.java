import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, sum, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		init();
		
		// 오름차순 정렬
		Arrays.sort(arr);
		// 양 끝점을 포인터로 조정
		int i = 0;
		int j = N-1;
		// 탐색 시작
		while (i<j) {
			int cur = arr[i]+arr[j];
			if (cur == sum) {
				ans += 1;
				i += 1;
				j -= 1;
			}
			else if (cur < sum) {
				i += 1;
			}
			else if (cur > sum) {
				j -= 1;
			}
		}
		
		System.out.println(ans);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sum = Integer.parseInt(br.readLine());
	}
}
