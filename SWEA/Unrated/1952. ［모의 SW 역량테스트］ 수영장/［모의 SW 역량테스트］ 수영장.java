import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] costs = new int[4];
	static int[] plan = new int[12];
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 요금 배열 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}
			// 월별 이용 계획
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			// 12달은 1번 지출하면 끝이므로 최소값의 초기값으로 지정
			min = costs[3];
			
			dfs(0, 0);

			System.out.println("#" + t + " " + min);
		}
	}

	static void dfs(int month, int cost) {

		if (cost >= min)
			return;
		if (month >= 12) {
			min = Math.min(cost, min);
			return;
		}

		// 1일권
		dfs(month + 1, cost + costs[0] * plan[month]);
		// 1달권
		dfs(month + 1, cost + costs[1]);
		// 3달권
		dfs(month + 3, cost + costs[2]);
	}
}
