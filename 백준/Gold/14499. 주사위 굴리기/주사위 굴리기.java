import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	// 동 서 븍 남
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	// 1: 위, 2: 뒤, 3: 오, 4: 왼, 5: 앞, 6: 아래
	static int[] dice = new int[7];
	static int[][] map;
	static int[] coms;
	static int N, M, x, y, K;

	public static void main(String[] args) throws IOException {
		init();
		// 시작지점의 위치 복사
		if (map[x][y]!=0) {
			dice[6] = map[x][y];
			map[x][y] = 0;
		}
		// 작업 시작
		for (int com : coms) {
			// 좌표 이동
			int nx = x + dr[com-1];
			int ny = y + dc[com-1];
			if (nx < 0 || nx >= N || ny < 0 || ny>=M) continue;
			
			// 주사위 굴리기
			rollDice(com-1);
			
			// 값 복사
			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[6];
			} else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}
			x = nx;
			y = ny;
			sb.append(dice[1]).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) { 
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		coms = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<K; i++) {
			coms[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void rollDice(int dir) {
		// 동쪽일 때
		if (dir == 0) {
			int temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = temp;
		}
		// 서쪽일 때
		else if (dir == 1) {
			int temp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = temp;
		}
		// 북쪽일 때
		else if (dir == 2) {
			int temp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = temp;
		}
		// 남쪽일 때
		else {
			int temp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = temp;
		}
	}

}
