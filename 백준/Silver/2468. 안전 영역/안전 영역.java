import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] visited;
	static int[][] map;
	static int max;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 지도 정보 입력받으면서 최대 강수량 저장
		int maxRain = 0;
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				int h = Integer.parseInt(st.nextToken());
				map[r][c] = h;
				if (h > maxRain) {
					maxRain = h;
				}
						
			}
		}
		// 높이 2부터 최대강수량 전까지 모두 탐색
		max = 1;	// 최소 1덩어리부터 시작하므로 1로 초기화
		for (int rain = 1; rain < maxRain; rain++) {
			// 방문배열 초기화
			visited = new boolean[N][N];
			// 탐색 횟수 = 영토 개수
			int cnt = 0;
			// 강수량보다 높은 고도 & 아직 방문 안한 곳 탐색
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (visited[r][c]) continue;
					if (map[r][c] <= rain) continue;
					visited[r][c] = true;
					dfs(r, c, rain);
					cnt++;
				}
			}
			if (cnt > max) {
				max = cnt;
			}
		}
		System.out.println(max);
	}
	
	private static void dfs(int r, int c, int rain) {
		for (int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 배열 범위 넘거나 방문했으면 패스
			if (nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc] <= rain) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, rain);
		}
	}
}
