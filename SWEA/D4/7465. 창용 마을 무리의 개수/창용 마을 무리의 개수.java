
/*
 * 연결되어있는 집단의 개수를 구하는 문제
 * DFS 혹은 BFS를 통해 연결된 무리를 모두 확인. 
 * 방문 체크 배열을 활용하여 아직 방문 체크되지 않은 노드가 있다면
 * 해당 노드부터 탐색하며 무리의 개수를 카운트
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static boolean[] visited;
	static ArrayList<Integer>[] link;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 인원, 관계 수 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 방문체크 배열, 아는사람리스트 배열 초기화
			visited = new boolean[N + 1];
			link = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				link[i] = new ArrayList<>();
			}
			
			// 아는사람 리스트 생성
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int person1 = Integer.parseInt(st.nextToken());
				int person2 = Integer.parseInt(st.nextToken());
				
				link[person1].add(person2);
				link[person2].add(person1);
			}
			cnt = 0;
			// 1번 사람부터 방문 기록 체크 안되어있는 경우 탐색하고 cnt + 1
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					dfs(i);
					cnt++;
				}
			}
			// 최종 cnt 수 출력
			System.out.println("#"+t+" "+cnt);
		}
	}
	static void dfs (int v) {
		if (visited[v]) {
			return;
		}
		// 방문 체크
		visited[v] = true;
		// v가 아는 사람들 모두 방문하여 체크
		for (int i : link[v]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}
}
