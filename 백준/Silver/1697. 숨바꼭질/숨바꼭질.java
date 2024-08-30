import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int cnt = 0;
	static int[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		cnt = 0;
		visit = new int[Math.max(N, M) * 2];
		if (N == M) {
			System.out.println(0);
			return;
		}
		BFS(N);

		System.out.println(cnt);
	}

	static void BFS(int v) {
		Queue<int[]> queue = new LinkedList<>();
		// 배열을 큐에 추가
		// {노드 번호, 이동 횟수}
		queue.add(new int[] { v, 1 });
		// 방문체크 + 이동횟수 입력
		visit[v] = 1;
		// 큐에서 꺼내며 작업
		while (!queue.isEmpty()) {
			// 큐에서 꺼내기
			int[] tmp = queue.poll();
			// 걷기 +1
			// 방문체크
			if (tmp[0] + 1 < visit.length) {
				if (tmp[0] + 1 == M) {
					cnt = tmp[1];
					return;
				}
				// 아직 방문 안했다면 방문 체크 후 큐에 삽입
				// 한 번 더 이동한 것이므로 1번 인덱스에 +1 하여 대입

				if (visit[tmp[0] + 1] == 0) {
					visit[tmp[0] + 1] = tmp[1] + 1;
					queue.add(new int[] { tmp[0] + 1, tmp[1] + 1 });
				}
			}
			// 걷기 -1
			if (tmp[0] - 1 >= 0) {
				if (tmp[0] - 1 == M) {
					cnt = tmp[1];
					return;
				}
				if (visit[tmp[0] - 1] == 0) {
					visit[tmp[0] - 1] = tmp[1] + 1;
					queue.add(new int[] { tmp[0] - 1, tmp[1] + 1 });
				}
			}
			// 순간이동 *2
			if (tmp[0] * 2 < visit.length) {
				if (tmp[0] * 2 == M) {
					cnt = tmp[1];
					return;
				}

				if (visit[tmp[0] * 2] == 0) {
					visit[tmp[0] * 2] = tmp[1] + 1;
					queue.add(new int[] { tmp[0] * 2, tmp[1] + 1 });
				}
			}
		}
	}
}
