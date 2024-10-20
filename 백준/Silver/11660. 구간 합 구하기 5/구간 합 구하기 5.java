import java.util.Scanner;

public class Main {
	static class Zone {
		int r1, c1, r2, c2;
		public Zone() {
		}
		@Override
		public String toString() {
			return "Zone [r1=" + r1 + ", c1=" + c1 + ", r2=" + r2 + ", c2=" + c2 + "]";
		}
		public Zone(int r1, int c1, int r2, int c2) {
			super();
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
		}
	}
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int max;
	static Zone[] zones;
	static int[][] matrix;
	static int[][] sum;
	public static void main(String[] args) {
		init(); // 입력 및 초기화
		
		for (Zone zone : zones) 
			sb.append(cal(zone)).append('\n');
		
		System.out.println(sb);
	}
	private static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 행렬 입력
		matrix = new int[N+1][N+1];
		sum = new int[N+1][N+1];
		for (int r=1; r<=N; r++) {
			for (int c=1; c<=N; c++) {
				matrix[r][c] = sc.nextInt();
				sum[r][c] = matrix[r][c] + sum[r-1][c] + sum[r][c-1] - sum[r-1][c-1];
			}
		}
		
		// M개만큼의 구해야할 구역을 객체로 생성해 배열로 관리
		zones = new Zone[M];
		for (int i=0; i<M; i++) {
			zones[i] = new Zone(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
	}
	static int cal(Zone zone) {
		return sum[zone.r2][zone.c2] - sum[zone.r1-1][zone.c2]- sum[zone.r2][zone.c1-1] + sum[zone.r1-1][zone.c1-1];
	}
}
