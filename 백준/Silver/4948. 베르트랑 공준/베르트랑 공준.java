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
	static int max;
	static ArrayList<Integer> inputs;
	static boolean[] filter;
	public static void main(String[] args) throws IOException {
		init();
		
		filter = new boolean[max*2+1];
		
		// 에라토스테네스의 체
		for (int i=2; i*i<=max*2; i++) {
			for (int j=i+i; j<=max*2; j+=i) {
				filter[j] = true;
			}
		}
		
		for (int n : inputs) {
			int cnt = 0;
			for (int i=n+1; i<=2*n; i++) {
				if (!filter[i]) {
					cnt+=1;
				}
			}
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		inputs = new ArrayList<>();
		max = 0;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			inputs.add(n);
			max = Math.max(max, n);
		}
	}
}
