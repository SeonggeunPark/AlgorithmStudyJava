import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 방향그래프 BFS or DFS탐색
 * A가 B를 신뢰한다: B -> A 단방향 인접
 */

public class Main {
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int N, M, max;
	static List<Integer> answers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		max = 0;
//		ans = 0;
		answers = new ArrayList<>();

		// 인접리스트 초기화
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		// 인접리스트 작성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken()); // 끝점
			int s = Integer.parseInt(st.nextToken()); // 시작점

			adjList[s].add(e); // 인접리스트에 기록
		}

		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			int hackedCount = BFS(i);
			if (max < hackedCount) {
				max = hackedCount;
				answers.clear();
				answers.add(i);
			} else if (max == hackedCount) {
				answers.add(i);
			}
		}

		for (int ans : answers) {
			System.out.print(ans + " ");
		}
	}

	private static int BFS(int i) {
		Arrays.fill(visited, false);

		Queue<Integer> q = new LinkedList<>();

		visited[i] = true; // 시작점 방문체크
		q.add(i); // 시작점 큐 삽입
		int hackingCount = 1; // 해킹한 컴퓨터 개수

		while (!q.isEmpty()) {
			int curr = q.poll(); // 큐에서 뽑기

			// 인접리스트 확인
			for (int com : adjList[curr]) {
				if (visited[com])
					continue;
				visited[com] = true;
				q.add(com);
				hackingCount += 1;
			}
		}

		return hackingCount;
	}
}