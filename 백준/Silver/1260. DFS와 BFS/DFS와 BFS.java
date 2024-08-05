import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A; // 인접노드 리스트
	static boolean visitedDFS[]; // 방문 기록 리스트
	static boolean visitedBFS[]; // 방문 기록 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		// n+1만큼 인접리스트, 방문기록 리스트 초기화 (1부터 카운트하기위해)
		A = new ArrayList[n + 1];
		visitedDFS = new boolean[n + 1];
		visitedBFS = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			A[i] = new ArrayList<>(); // 배열 각 방에 리스트 열어주기
		}

		// 인접 리스트 채우기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			A[s].add(e);
			A[e].add(s);
		}
		// 작은 번호부터 먼저 탐색하기 위해 정렬
		for (int i = 1; i < n + 1; i++) {
			Collections.sort(A[i]);
		}

		DFS(v);
		System.out.println();
		BFS(v);
		System.out.println();
	}
    // 재귀함수를 통해 깊이 우선 탐색 가능
	static void DFS(int v) {
		if (visitedDFS[v]) {
			return;
		}
		visitedDFS[v] = true; // 방문하기
		System.out.print(v + " ");
		// 인접한 애들 중 방문 안한 애들 방문
		for (int i : A[v]) {
			if (visitedDFS[i] == false) {
				DFS(i);
			}
		}
	}
	// (1) 큐에 추가
	// (2) 방문기록
	// (3) 큐에서 빼면서 탐색 순서에 기록
	// (4) 동시에 인접 노드 큐에 삽입 (= (1)큐에 추가) > 큐에 더이상 없을 때까지 반복
	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();

		if (visitedBFS[v]) {
			return;
		}
		queue.add(v);
		visitedBFS[v] = true;

		while (!queue.isEmpty()) {
			int n = queue.poll();	// 큐에서 빼기
			System.out.print(n + " ");		// 탐색 순서 기록
			for (int i : A[n]) {			// 인접 노드 큐에 삽입하면서 방문 기록
				if (visitedBFS[i] == false) {
					queue.add(i);
					visitedBFS[i] = true;
				}
			}
		}

	}
}
