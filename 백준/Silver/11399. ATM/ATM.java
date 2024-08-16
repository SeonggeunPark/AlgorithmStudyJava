import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] waiting = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			waiting[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(waiting);

		int sum = 0;
		int stack = 0;
//		System.out.println(Arrays.toString(waiting));
		for (int i : waiting) {
			stack += i;
			sum += stack;
		}

		System.out.println(sum);
	}
}
