import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int count, N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		count = 0;
		visited = new boolean[N][M];
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 벽 세우기
		createWallByDFS(0);
		
		System.out.println(count);
	}

	private static void countSafeZone(int[][] multipliedMap) {

		int tmpCount = 0;
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (multipliedMap[r][c] == 0) {
					tmpCount += 1;
				}
			}
		}
		if (tmpCount > count) {
			count = tmpCount;
		}
	}

	// 재귀메서드로 벽을 세우는 모든 경우의 수 탐색
	private static void createWallByDFS(int wall) {
		if (wall >= 3) {
			// 바이러스 증식시키기
			multiplyVirus();
			return;
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					createWallByDFS(wall + 1);
					map[r][c] = 0;
				}
			}
		}
	}
	// 바이러스 증식시키기
	private static void multiplyVirus() {
		int[][] tmpMap = new int[N][M];
		// 배열 복사
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				tmpMap[r][c] = map[r][c];
			}
		}
		// 방문배열 초기화
		for (int r = 0; r < N; r++) {
			Arrays.fill(visited[r], false);
		}
		
		// 바이러스가 있는 모든 구역을 찾아 BFS를 통해 바이러스 증식
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (tmpMap[r][c] == 2 && !visited[r][c]) {
//					BFS(r, c, setmap);
					Queue<int[]> q = new LinkedList<>();
					
					visited[r][c] = true;
					q.add(new int[] {r, c});
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						for (int dir = 0; dir<4; dir++) {
							int nr = curr[0] + dr[dir];
							int nc = curr[1] + dc[dir];
							
							if (nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
							if (tmpMap[nr][nc] != 0) continue;
							
							tmpMap[nr][nc] = 2;
							q.add(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
//		for (int r=0; r<N; r++) {
//			System.out.println(Arrays.toString(setmap[r]));
//		}
//		System.out.println();
		// 안전영역 세기
		countSafeZone(tmpMap);
	}
//	// 주변이 0인 구역만 큐에 담아 바이러스 증식
//	static void BFS(int r, int c) {
//		Queue<int[]> q = new LinkedList<>();
//		
//		visited[r][c] = true;
//		q.add(new int[] {r, c});
//		while(!q.isEmpty()) {
//			int[] curr = q.poll();
//			for (int dir = 0; dir<4; dir++) {
//				int nr = curr[0] + dr[dir];
//				int nc = curr[1] + dc[dir];
//				
//				if (nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
//				if (map[nr][nc] != 0) continue;
//				
//				map[nr][nc] = 2;
//				q.add(new int[] {nr, nc});
//				visited[nr][nc] = true;
//			}
//		}
//	}
}
