import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max;
	static int[][] paper;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 완전탐색 시작
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				visited[r][c] = true;
				DFS(r, c, 1, paper[r][c]);
				visited[r][c] = false;
			}
		}
		
		System.out.println(max);
	}
	// 우 하 상만 적용
	static int[] dr = {0, -1, 1};
	static int[] dc = {1, 0, 0};
	private static void DFS(int r, int c, int count, int score) {
		if (count >= 4) {
			if (score > max) {
				max = score;
			}
			return;
		}
		if ((4-count)*1000+score <= max) return;
		
		// 3방향 탐색
		for (int dir=0; dir<3; dir++) {
			// 첫번째에서는 상으로 이동 X
			if (count==1 && dir==2) continue;
			
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			
			if (nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			// 현재 위치에서 해당 방향 점수만 먹기
			DFS(r, c, count+1, score+paper[nr][nc]);
			// 해당 방향으로 이동하기
			DFS(nr, nc, count+1, score+paper[nr][nc]);
			visited[nr][nc] = false;
		}
		
	}
}
