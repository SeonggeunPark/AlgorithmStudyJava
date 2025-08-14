import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, K, L;
	static int[][] board;
	static String[][] turns;
	static ArrayList<int[]> snake;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		init();

		int tIdx = 0; // 방향전환 배열 추적 인덱스
		int time = 1; // 시간 흐름
		int dir = 1; // 시작은 오른쪽 방향
		while (true) {
			int r = snake.get(snake.size() - 1)[0];
			int c = snake.get(snake.size() - 1)[1];
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			// 벽 체크
			if (nr < 1 || nr > N || nc < 1 || nc > N)
				break ;
			// 몸통 충돌 체크
			if (board[nr][nc] == 1) break;

			// 사과 있는지 체크
			boolean hadApple = false;
			if (board[nr][nc] == 2) {
				hadApple = true;
				board[nr][nc] = 0;
			}

			// 사과 안먹었으면 꼬리 제거
			if (!hadApple) {
				board[snake.get(0)[0]][snake.get(0)[1]] = 0;
				snake.remove(0);
			}

			// 이동
			snake.add(new int[] { nr, nc });
			board[nr][nc] = 1;
			

			// 방향전환 타이밍인지 체크
			if (tIdx < turns.length && time == Integer.parseInt(turns[tIdx][0])) {
				if (turns[tIdx][1].equals("L")) {
					dir = (dir + 3) % 4;
				} else {
					dir = (dir + 1) % 4;
				}
				tIdx += 1;
			}
			
			// 시간 경과
			time += 1;
		}

		System.out.println(time);
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		board[1][1] = 1;
		// 맨 마지막 인덱스가 뱀의 머리
		snake = new ArrayList<>(Arrays.asList(new int[] { 1, 1 }));

		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}

		L = Integer.parseInt(br.readLine());
		turns = new String[L][2];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			turns[i][0] = st.nextToken();
			turns[i][1] = st.nextToken();
		}
	}
}
