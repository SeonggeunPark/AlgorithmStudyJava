import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] snack;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}

			max = -1;
			bestPick(0, 0, 0);

			System.out.println("#" + t + " " + max);
		}
	}

	static void bestPick(int idx, int count, int sum) {
		if (sum > M)
			return;
		if (count >= 2) {
			max = Math.max(max, sum);
			return;
		}
		if (idx >= N) return;
		
		// 현재 과자를 고른다
		bestPick(idx + 1, count+1, sum + snack[idx]);

		// 안고른다
		bestPick(idx + 1, count, sum);
	}
}
