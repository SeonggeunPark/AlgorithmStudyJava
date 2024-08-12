import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int nr, nc;
		
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] balloons = new int[N][M];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					balloons[r][c] = sc.nextInt();
				}
			}
			int sum = 0;
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					sum=0;
					sum += balloons[r][c];
					for (int i=0; i<4; i++) {
						nr = r + dr[i];
						nc = c + dc[i];
						if (0<=nr && nr<N && 0<=nc && nc<M) {
							sum += balloons[nr][nc];
						}
					}
					
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

}