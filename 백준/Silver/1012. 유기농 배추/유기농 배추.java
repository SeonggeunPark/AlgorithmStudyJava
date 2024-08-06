import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 인접노드 리스트, 방문 확인 리스트 미리 만들기 (static)
//	static ArrayList<Integer[][]>[][] near;
	static boolean[][] visited;
	static int[][] land;
	static int M, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			int K = Integer.parseInt(st.nextToken()); // 배추(노드) 개수
			
			// 2차원 땅 생성 및 입력
			land = new int[M][N];
			int r, c;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				land[r][c] = 1;
			}

			visited = new boolean[M][N]; // 방문 체크 배열 초기화
//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < N; j++) {
//					near[i][j] = new ArrayList<Integer[][]>(); // 배열 각 방에 리스트 열어주기(초기화)
//				}
//			}

//		// 인접노드 리스트 만들기
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				if (land[i][j] == 1) {
//					
//				}
//			}
//		}

			int count = 0; // 배추심은 구역 카운트할 변수
			// 0,0부터 탐색
			// 배추가 심어져 있으면서,
			// 아직 방문하지 않았다면 => DFS 시작
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (land[i][j] == 1 && !visited[i][j]) {
//						System.out.println(i +", " + j);
						DFS(land, i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}

	}
	
	//				   상  하  좌  우
	static int[] dr = {-1, 1, 0, 0 };
	static int[] dc = {0, 0, -1, 1};
	static int nr, nc;
	
	static void DFS(int[][] land, int r, int c) {
		// base case
		if (visited[r][c])
			return;
		
		// 해당 위치 방문 처리
		visited[r][c] = true;
		
		// 상,하,좌,우 노드가 배열 범위를 넘지 않으면서,
		// 값이 1이면서,
		// 아직 방문하지 않은 곳이라면
		// => DFS 탐색
		for (int idx = 0; idx<4; idx++) {
			nr = r + dr[idx];
			nc = c + dc[idx];
			
			if (0 <= nr && nr < land.length && 
				0 <= nc && nc < land[r].length && 
				land[nr][nc] == 1 && visited[nr][nc] == false) {
				
				DFS(land, nr, nc);
			}
		}
	}
}
