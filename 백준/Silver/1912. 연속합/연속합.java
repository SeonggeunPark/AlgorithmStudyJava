import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		init();

		int max = arr[0], current = arr[0];
		for (int i = 1; i < N; i++) {
		    current = Math.max(arr[i], current + arr[i]);
		    max = Math.max(max, current);
		}

		System.out.println(max);
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
