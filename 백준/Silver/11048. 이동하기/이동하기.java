import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 동적계획법
 * r,c에 도착할 때 최대값은
 * (1) r-1, c 까지의 최대값
 * (2) r, c-1 까지의 최대값
 * (3) r-1, c-1 까지의 최대값
 * 
 * 값 중 가장 큰 값에 현재 위치 사탕 개수를 더한 것과 같다.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,M; 
	static int[][] dp;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		init();
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				int curr = map[r][c];
				int max = curr;
				if (r-1>=0 && c-1>=0) {
					max = Math.max(max, curr+dp[r-1][c-1]);
				}
				if (r-1 >= 0) {
					max = Math.max(max, curr+dp[r-1][c]);
				}
				if (c-1 >= 0) {
					max = Math.max(max, curr+dp[r][c-1]);
				}
				dp[r][c] = max;
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
	private static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[N][M];
		map = new int[N][M];
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
	}
}
