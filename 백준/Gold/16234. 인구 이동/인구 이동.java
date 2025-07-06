import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, L, R, searchCnt, ans, totalNation, totalPopulation;
	static int[][] lands;
	static int[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		init();

		// 매일 작업을 반복
		while (searchCnt < N * N) {
			// 변수 초기화
			ans += 1;
			searchCnt = 0;
			for (int r=0; r<N; r++) {
				Arrays.fill(visited[r], 0);
			}
			
			// 모든 칸 연합 여부 체크 (DFS)
			// 재귀탐색 종료 후 리턴값을 통해 인구수 수정
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visited[r][c] > 0)
						continue; // 이미 방문(연합 처리)한 칸은 통과
					
					// 방문 처리
					visited[r][c] = ++searchCnt;
					
					// 탐색 전 변수 초기화
					totalNation = 1;
					totalPopulation = lands[r][c];
					
					// 개방할 나라 탐색
					DFS(r, c);

					// 개방한 나라 인구 조정
					movePopulation(r, c);
				}
			}
		}

		System.out.println(ans);
	}

	private static void movePopulation(int currR, int currC) {
		// 인구 조정
		lands[currR][currC] = totalPopulation / totalNation;
		// 재방문하지 않도록 방문한 칸 초기화
		visited[currR][currC] = Integer.MAX_VALUE;
		// 4방 탐색
		for (int dir = 0; dir < 4; dir++) {
			int nr = currR + dr[dir];
			int nc = currC + dc[dir];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] != searchCnt)
				continue;
			
			movePopulation(nr, nc);
		}
	}

	private static void DFS(int currR, int currC) {
//		System.out.println("탐색시작 --- "+currR+", "+currC);
		// 4방 탐색
		for (int dir = 0; dir < 4; dir++) {
			int nr = currR + dr[dir];
			int nc = currC + dc[dir];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] > 0)
				continue;

			int diff = Math.abs(lands[currR][currC] - lands[nr][nc]);
			if (diff < L || diff > R)
				continue;

			visited[nr][nc] = searchCnt;
			totalNation += 1;
			totalPopulation += lands[nr][nc];
			DFS(nr, nc);
		}
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		lands = new int[N][N]; // 땅 배열
		visited = new int[N][N]; // 방문 배열
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				lands[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		searchCnt = 0; // 탐색 횟수 카운트 (인구 이동이 끝나는 시점 파악하기 위함)
		ans = -1; // 인구 이동 기간 카운트
		
	}
}