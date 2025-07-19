import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 백준 15683 - 감시
 * CCTV 최대 8개, 사무실은 최대 64칸 별로 크지 않으므로
 * 브루트포스로 풀 수 있을 것으로 보임
 * 모든 칸 탐색해서 CCTV 각도 맞춰두고 최소값을 갱신
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static class CCTV {
		int r;
		int c;
		int num;
		public CCTV(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	// cctv의 기본 방향을 미리 설정
	static ArrayList<Integer>[] cctvTypes = new ArrayList[] {
            null,
            new ArrayList<>(Arrays.asList(1)),
            new ArrayList<>(Arrays.asList(1, 3)),
            new ArrayList<>(Arrays.asList(0, 1)),
            new ArrayList<>(Arrays.asList(0, 1, 3)),
            new ArrayList<>(Arrays.asList(0, 1, 2, 3))
        };
	static int N, M, min;
	static int[][] map;
	static ArrayList<CCTV> cctvs = new ArrayList<>();
	// 상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		init();
		
		DFS(0);
		
		System.out.println(min);
	}
	// 모든 CCTV를 순회하여 최적 각 찾음
	private static void DFS(int idx) {
		// 재귀 종료 조건
		if (idx >= cctvs.size()) {
			// 사각지대 수 체크 후 최소값 갱신
			int blind = 0;
//			System.out.println("======최종======");
			for (int r=0; r<N; r++) {
//				System.out.println(Arrays.toString(map[r]));
				
				for (int c=0; c<M; c++) {
					if (map[r][c]==0) {
						blind += 1;
					}
				}
			}
			min = Math.min(min, blind);
			return;
		}
		
		CCTV curr = cctvs.get(idx);
		int r = curr.r;
		int c = curr.c;
		int num = curr.num;
		
		// 1, 3, 4 카메라는 4가지
		// 2번 카메라는 2가지
		// 5번 카메라는 1가지 경우의 수.
		for (int i=0; i<4; i++) {
			// 2, 5번 카메라는 경우의 수 넘으면 pass
			if (num==2 && i>=2) continue;
			if (num==5 && i>=1) continue;
			
			// 카메라 각도에 따라 map 조정
			for (int dir : cctvTypes[num]) {
//				System.out.println(dir);
//				System.out.println((dir+i)%4+"방향 CCTV 켜기");
				turnOnCCTV(r,c,(dir+i)%4);
			}
			
			DFS(idx+1);
			
			// 원상복구
//			System.out.println("CCTV 끄기");
			for (int dir : cctvTypes[num]) {
				turnOffCCTV(r,c,(dir+i)%4);
			}
		}
	}
	private static void turnOnCCTV(int r, int c, int dir) {
		// 카메라인 경우에는 작업하지 않고 다음 칸으로
		if (map[r][c] <= 0) {
			map[r][c] -= 1;
		}
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		// 지도 범위 밖이거나 벽이면 작업 종료
		if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc]==6) return;
		
		turnOnCCTV(nr, nc, dir);
	}
	private static void turnOffCCTV(int r, int c, int dir) {
		// 카메라인 경우에는 작업하지 않고 다음 칸으로
		if (map[r][c] <= 0) {
			map[r][c] += 1;
		}
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		// 지도 범위 밖이거나 벽이면 작업 종료
		if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc]==6) return;
		
		turnOffCCTV(nr, nc, dir);
	}
	private static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (1<=map[r][c]&&map[r][c]<=5) {
					cctvs.add(new CCTV(r, c, map[r][c]));
				}
			}
		}
		min = Integer.MAX_VALUE;
	}
}
