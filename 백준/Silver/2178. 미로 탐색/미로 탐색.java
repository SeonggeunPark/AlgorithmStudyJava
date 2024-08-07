import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int M, N;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// map 입력
		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		visited = new boolean[N][M];

		BFS();

        System.out.println(count);

	}

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int nr, nc;
	static ArrayList<Integer> pos, npos; // 큐에 담을 좌표값 선언
	static ArrayList<ArrayList<Integer>> poses, nposes; // 큐에 담을 좌표 모음
	// BFS 메서드

	static void BFS() {
		Queue<ArrayList<ArrayList<Integer>>> queue = new LinkedList<>();
		// 이미 방문했으면 종료
		if (visited[0][0])
			return;
		// 좌표값 저장할 리스트 변수 선언 및 현재 위치(0,0) 지정
		pos = new ArrayList<>();
		poses = new ArrayList<>();
		pos.add(0);
		pos.add(0);

		poses.add(pos);

		// 현재 위치 방문 처리 & 큐에 삽입
		queue.offer(poses);
		visited[0][0] = true;
		count++;

		// 도착지점 방문 체크될 때까지 반복
		while (visited[visited.length - 1][visited[0].length - 1] == false) {
			// (1)큐에 노드 위치 제거 =>
			// (2)인접 노드 큐에 삽입 =>
			// (3)방문 처리
			// 반복
			poses = queue.poll(); // (1)
//            System.out.println(pos);
//			int searchCount = 0;
			nposes = new ArrayList<>();
			for (ArrayList<Integer> pos : poses) {
				for (int idx = 0; idx < 4; idx++) {
					// npos 계속 초기화해야 리스트 사이즈 2개 유지됨
					npos = new ArrayList<>();
//                System.out.println(queue);
					// 상하좌우가 범위 넘어가지 않으면서,
					// 배추가 심어져 있으면서,
					// 방문한 적 없으면
					// => 큐에 삽입 + 방문 처리
					nr = pos.get(0) + dr[idx];
					nc = pos.get(1) + dc[idx];
					if (0 <= nr && nr < map.length && 0 <= nc && nc < map[0].length && map[nr][nc] == 1
							&& visited[nr][nc] == false) {

						npos.add(nr);
						npos.add(nc);
						nposes.add(npos); // (2)
						visited[nr][nc] = true; // (3)
//						searchCount++;
					}
				}
			}
			queue.add(nposes);
			count++;
		}
	}
}