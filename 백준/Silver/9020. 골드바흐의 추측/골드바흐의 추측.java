import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int T, max;
	static int[] inputs;
	static boolean[] filter;

	public static void main(String[] args) throws IOException {
		init();

		filter = new boolean[max + 1];

		// 에라토스테네스의 체
		for (int i = 2; i * i <= max; i++) {
			for (int j = i + i; j <= max; j += i) {
				filter[j] = true;
			}
		}

		for (int n : inputs) {
			int l = n / 2;
			int r = n - l;

			while (true) {
				if (!filter[l] && !filter[r]) {
					sb.append(l).append(' ').append(r).append('\n');
					break;
				}
				l -= 1;
				r += 1;
			}
		}

		System.out.println(sb);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		max = 0;
		T = Integer.parseInt(br.readLine());
		inputs = new int[T];
		for (int i = 0; i < T; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, inputs[i]);
		}
	}
}
