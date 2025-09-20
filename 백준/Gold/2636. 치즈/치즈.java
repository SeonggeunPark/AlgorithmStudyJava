import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int[][] map = new int[R][C];
		
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		int time = 0;
		Queue<int[]> q = new ArrayDeque();
		int prev = 0;
		
		while (true) {
//			for (int r=0; r<R; r++) {
//				System.out.println(Arrays.toString(map[r]));
//			}
//			System.out.println();
			
			int curCnt = 0;
			boolean isEmpty = true;
			for (int r=0; r<R; r++) {
				for (int c=0; c<C; c++) {
					if (map[r][c]!=1) continue;
					curCnt+=1;
					isEmpty = false;
					for (int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						
						if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
						if (map[nr][nc] == 1) continue;
						
						// 격자 부딪히냐
						if (!checkOutside(nr, nc, R, C, map)) continue;
						
						q.offer(new int[] {r,c});
						break;
					}
				}
			}
			if (isEmpty) break;
			
			prev = curCnt;
			// 치즈 녹이기
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				map[cur[0]][cur[1]] = 0;
			}
			
			
			time += 1;
		}

		System.out.println(time);
		System.out.println(prev);
	}

	private static boolean checkOutside(int startR, int startC, int R, int C, int[][] map) {
		Queue<int[]> q = new ArrayDeque();
		boolean[][] visited = new boolean[R][C];
		
		visited[startR][startC] = true;
		
		q.offer(new int[] {startR, startC});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r=cur[0];
			int c=cur[1];
			
			if (r==0 || r==R-1 || c==0 || c==C-1) {
				return true;
			}
			
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc]!=0) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		return false;
	}
}