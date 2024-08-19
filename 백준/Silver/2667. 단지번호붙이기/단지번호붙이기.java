import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
// 						상   하   좌   우
	static int[] dr = { -1, 1, 0, 0, };
	static int[] dc = { 0, 0, -1, 1, 1 };
//	static int[][] map;
	static boolean[][] booleanMap;
	static boolean[][] visited;
	static int N;
	static int housecnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
//		map = new int[N][N];
		int[] cities = new int[N*N];
		booleanMap = new boolean[N][N];
		visited = new boolean[N][N];

// 맵 생성
		for (int r = 0; r < N; r++) {
			char[] tmp = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				if (tmp[c] == '1') {
					booleanMap[r][c] = true;
				}
			}
		}

// 마을 번호 매기기
		int citycnt = 0;
		int idx=0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (booleanMap[r][c]) {
					housecnt = 0;
					citycnt++;
					numbering(r, c);
					cities[idx++] = housecnt;
				}
			}
		}
		
		Arrays.sort(cities);
		System.out.println(citycnt);
		for (int i=cities.length-citycnt ; i<=cities.length-1; i++) {
			System.out.println(cities[i]);
		}
	}

	static void numbering(int r, int c) {
		if (!booleanMap[r][c])
			return;
		
		housecnt++;
		visited[r][c] = true;
		booleanMap[r][c] = false;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
				if (booleanMap[nr][nc]) {
					numbering(nr, nc);
				}
			}
		}
	}
}