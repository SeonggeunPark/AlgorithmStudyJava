import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] table = new int[N + 1];
		table[1] = 1;

		int i = 1;
		int cnt = 0;
		while (table[i] < M) {
			i = table[i] % 2 == 1 ? (i + L > N ? L - N + i : i + L) : (i - L < 1 ? N - L + i : i - L);
			table[i] += 1;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
