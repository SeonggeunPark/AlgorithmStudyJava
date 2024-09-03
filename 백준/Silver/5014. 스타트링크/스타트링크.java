import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * DFS로 풀어보려 했으나, stackoverflow가 발생.
 * BFS로 구현한 결과 첫 시도에서 메모리 초과가 발생하였음.
 * 원인은 방문체크 시점이었음. 큐에서 꺼낸 직후 방문 체크하였으나,
 * 큐에 넣을 때 방문체크하면 메모리초과가 발생하지 않음.
 * BFS 시작 시점에 현재 층을 방문 체크하였는데, 반복문 시작 시에
 * 중복하여 방문 체크한 것이 원인으로 보임
 */
public class Main  {
	static int F, S, G, U, D;
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());	// 최대 층
		S = Integer.parseInt(st.nextToken());	//현재 층
		G = Integer.parseInt(st.nextToken());	//목표 층
		U = Integer.parseInt(st.nextToken());	//한번에 올라갈 수 있는 층 수
		D = Integer.parseInt(st.nextToken());	//한번에 내려갈 수 있는 층 수
		
		// 한번 갔던 층은 다시 방문하지 않기 위해 방문 체크 배열 생성
		visited = new boolean[F + 1];
		// 너비우선팀섹
		int ans = bfs(S);
		
		if (ans == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
	}

	static int bfs(int floor) {
		Queue<Integer> q = new LinkedList<>();
		// 현재 층 방문 체크
		visited[floor] = true;
		// 이동 횟수 저장할 변수
		int cnt = 0;
		// 큐의 사이즈 저장할 변수
		int size = 1;
		// 큐에 현재 층 삽입
		q.add(S);
		// 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			// 같은 높이에 있는 노드를 함께 처리하고 카운트하기 위해 size 사용
			for (int i=0; i<size; i++) {
				int popItem = q.poll();
				// 꺼낸 노드가 목표 층과 같으면 종료
				if (popItem == G) return cnt;
				// 올라갈 층이 최대층보다 크지 않고, 아직 방문하지 않았다면 
				if (popItem+U <= F && !visited[popItem+U]) {
					// 방문 체크 후 큐에 삽입
					visited[popItem+U] = true;
					q.add(popItem+U);
				} // 내려갈 층이 1층보다 낮지 않고, 아직 방문하지 않았다면
				if (popItem-D >= 1 && !visited[popItem-D]) {
					// 방문체크 후 큐에 삽입
					visited[popItem-D] = true;
					q.add(popItem-D);
				}
			}
			// 다음 반복을 위해 큐 사이즈 저장
			size = q.size();
			cnt++;
		}
		
		return -1;
	}
//	static void dfs(int cnt, int floor) {
//		if (cnt >= ans) return;
//		if (floor == G) {
//			ans = Math.min(ans, cnt);
//			return;
//		}
//
//		// 올라가기 U
//		if (floor + U <= F && !visited[floor + U]) {
//			visited[floor + U] = true;
//			dfs(cnt + 1, floor + U);
//			visited[floor + U] = false;
//		}
//		// 내려가기 D
//		if (floor - D >= 1 && !visited[floor - D]) {
//			visited[floor - D] = true;
//			dfs(cnt + 1, floor - D);
//			visited[floor - D] = false;
//		}
//	}
}
