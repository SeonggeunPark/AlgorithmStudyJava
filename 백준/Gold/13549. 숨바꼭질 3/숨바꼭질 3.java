import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static boolean[] visited;
	static int min;

	// 초, 현재위치를 저장할 클래스
	static class Node {
		int pos;
		int time;

		public Node() {
		}

		@Override
		public String toString() {
			return "Node [pos=" + pos + ", time=" + time + "]";
		}

		public Node(int pos, int time) {
			super();
			this.pos = pos;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		K = Integer.parseInt(st.nextToken()); // 동생의 위치
		// 방문체크 배열 저장
		visited = new boolean[1000001];
		min = Integer.MAX_VALUE;

		BFS(N);
		
		System.out.println(min);
	}

	private static void BFS(int n) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n, 0)); // 출발지점 큐에 삽입
		visited[n] = true; // 방문체크

		while (!q.isEmpty()) {
			// 큐에서 빼기
			Node curr = q.poll();
			// 도착지점이면 탐색 종료
			if (curr.pos == K) {
				min = Math.min(curr.time, min);
				continue;
			}

			// *2
			if (curr.pos * 2 <= 100000 && !visited[curr.pos*2]) {
				visited[curr.pos * 2] = true;
				q.add(new Node(curr.pos * 2, curr.time));
			}
			// -1
			if (curr.pos - 1 >= 0 && !visited[curr.pos-1]) {
				visited[curr.pos - 1] = true; // 방문체크
				q.add(new Node(curr.pos - 1, curr.time + 1));
			}
			// +1
			if (curr.pos + 1 <= 100000 && !visited[curr.pos+1]) {
				visited[curr.pos + 1] = true; // 방문체크
				q.add(new Node(curr.pos + 1, curr.time + 1));
			}


		}
	}
}
