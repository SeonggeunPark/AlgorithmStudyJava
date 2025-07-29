import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N, ans;
	static int[][] matrix;

	static class Node implements Comparable<Node> {
		int value;
		int r;
		int c;

		public Node(int value, int r, int c) {
			this.value = value;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			// 최대 힙으로 바꿔야 하므로 내림차순
			return o.value - this.value;
		}
	}

	public static void main(String[] args) throws IOException {
		init();

		PriorityQueue<Node> pq = new PriorityQueue<>();

		// 처음에 가장 마지막 행의 모든 열을 큐에 넣음
		for (int c = 0; c < N; c++) {
			pq.offer(new Node(matrix[N - 1][c], N - 1, c));
		}

		// N번째로 큰 수를 찾을 때까지 N-1번 poll
		for (int i = 0; i < N - 1; i++) {
			Node curr = pq.poll();

			// 위쪽 행이 남아있다면 다음 값을 큐에 넣음
			if (curr.r - 1 >= 0) {
				pq.offer(new Node(matrix[curr.r - 1][curr.c], curr.r - 1, curr.c));
			}
		}

		System.out.println(pq.peek().value);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
