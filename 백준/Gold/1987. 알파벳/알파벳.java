import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] visited;
	static boolean[] alphabet;
	static char[][] board;
	static int R, C, ans;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행 수
		C = Integer.parseInt(st.nextToken()); // 열 수
		ans = 0;
		
		// 1행1열부터 시작하므로 (R+1)*(C+1) 크기 배열 생성
		board = new char[R][C]; 
		for (int r=0; r<R; r++) {
			board[r] = br.readLine().toCharArray();
		} // 보드판 입력
		// 방문 체크 배열 초기화
		visited = new int[R][C];
		// 알파벳 체크 배열 초기화
		alphabet = new boolean['Z'-'A'+1];
		
		visited[0][0] = 100;
		alphabet[board[0][0]-'A'] = true;
		DFS(0, 0, 1);
		
		System.out.println(ans);
	}
	private static void DFS(int r, int c, int cnt) {
		ans = Math.max(ans, cnt);
		// 지날 수 있는 최대 개수는 알파벳 개수
		if (cnt >= 'Z'-'A'+1) {
			return;
		}
		
		// 4방 탐색
		for (int dir = 0; dir < 4; dir ++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 범위 지났으면 PASS
			if (nr<0 || nr>=R ||nc<0 ||nc>=C) continue;
			// 이미 가지고 있는 알파벳이면 PASS
			if (alphabet[board[nr][nc]-'A']) continue;
//			visited[nr][nc] = Math.max(cnt+1, visited[nr][nc]);
			alphabet[board[nr][nc]-'A'] = true;
			DFS(nr, nc, cnt+1);
			alphabet[board[nr][nc]-'A'] = false;
		}
		
		
	}
}