import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		sb.append('<');

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		int cnt = N;
		int idx = -1;
		while (cnt > 0) {
			int jump = K;
			while (jump > 0) {
				idx = (idx + 1) % N;
				if (arr[idx] != 0)
					jump -= 1;
			}
			if (cnt > 1)
				sb.append(arr[idx]).append(',').append(' ');
			else
				sb.append(arr[idx]).append('>');
			
			arr[idx] = 0;
			cnt -= 1;
		}

		System.out.println(sb);
	}
}
