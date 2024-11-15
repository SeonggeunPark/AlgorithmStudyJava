import java.util.Scanner;

/*
 * 재귀메서드를 활용하여 1번째 날부터 N번째 날까지 모든 경우의 수를 탐색.
 */
public class Main {
	static int N, max;
	static int[][] schedule;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		max = 0;
		N = sc.nextInt();
		schedule = new int[N][2];

		for (int i = 0; i < N; i++) {
			schedule[i][0] = sc.nextInt();
			schedule[i][1] = sc.nextInt();
		}

		DFS(0, 0, 0);

		System.out.println(max);
	}

	private static void DFS(int idx, int cnt, int profit) {
		if (idx >= N) {
			max = Math.max(profit, max);
			return;
		}

		// 해당 날짜의 상담을 기간 내에 마칠 수 있는지 확인
		if (schedule[idx][0] <= N - idx) {
			// 상담을 한다
			if (cnt <= 0) {
				DFS(idx + 1, schedule[idx][0] - 1, profit + schedule[idx][1]);
			}
			// 상담을 안한다.
			DFS(idx + 1, cnt - 1, profit);
		} else
			// 상담을 할 수 없으면 무조건 못한다.
			DFS(idx + 1, cnt - 1, profit);
	}
}
