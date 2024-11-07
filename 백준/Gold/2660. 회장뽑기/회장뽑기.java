import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int num;
		int score;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", score=" + score + "]";
		}

		public Node(int num, int score) {
			super();
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Node o) {
			if (o.score == this.score) {
				return this.num - o.num; // 2. 번호 오름차순
			}
			return this.score - o.score; // 1. 점수 오름차순
		}
	}

	static int N;
//	static Node[] scores;
	static PriorityQueue<Node> scores;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 회원 수
		adjList = new ArrayList[N + 1]; // 회원 인접리스트
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		} // 인접리스트 초기화
//		scores = new int[N + 1]; // 점수 배열
		scores = new PriorityQueue<>();
		visited = new boolean[N+1];

		// 인접리스트 작성
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		while (s != -1 || e != -1) {
			adjList[s].add(e);
			adjList[e].add(s);
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
		}

		// 모든 회원의 점수를 계산
		for (int i = 1; i <= N; i++) {
			BFS(i);
		}

		StringBuilder sb = new StringBuilder();
//		System.out.println(scores);
//		Node first = scores.poll();
//		sb.append(first.num).append(' '); // 후보 번호
		int cand = 0;
		int min = Integer.MAX_VALUE;
		while (!scores.isEmpty()) {
			Node curr = scores.poll();
			if (curr.score > min)
				break;
			min = curr.score; // 회장 후보 점수
			cand += 1; // 회장 후보 수
			sb.append(curr.num).append(' ');
		}

		System.out.println(min + " " + cand);
		System.out.println(sb);
	}

	private static void BFS(int start) {
		Node member = new Node(start, 0);
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(visited, false); // 방문배열 초기화

		visited[start] = true; // 시작점 방문 체크
		q.add(start);
		int size = 1; // 큐 사이즈를 관리
		int cnt = -1; // 반복 횟수 관리

//		System.out.println(start+"번 시작!!!!!!!!!!");
		while (!q.isEmpty()) {
			for (int i = 0; i < size; i++) {
				int curr = q.poll();

				for (int node : adjList[curr]) {
					if (visited[node])
						continue;
					q.add(node);
					visited[node] = true;
//					System.out.println(node+"번 담음.");
				}
			}
			size = q.size();
			cnt += 1;
//			System.out.println(cnt+"바퀴 끝");
		}
		
		member.score = cnt;
		scores.add(member); // 계산 끝나면 우선순위큐에 삽입
	}
}
