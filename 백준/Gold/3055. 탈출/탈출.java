import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] map = new char[R][C];
		
		int dR = 0;
		int dC = 0;
		int sR = 0;
		int sC = 0;
		for (int r=0; r<R; r++) {
			map[r] = sc.next().toCharArray();
			for (int c=0; c<C; c++) {
				if (map[r][c]=='D') {
					dR = r;
					dC = c;
				} else if (map[r][c]=='S') {
					sR = r;
					sC = c;
				}
			}
		}
		
		int ans = bfs(sR, sC, map, R, C, dR, dC, sR, sC);
		
		System.out.println(ans==-1? "KAKTUS" : ans);
	}
	static int bfs(int startR, int startC, char[][] map, int R, int C, int dR, int dC, int sR, int sC) {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		Queue<int[]> q = new ArrayDeque();
		boolean[][] visited = new boolean[R][C];
		visited[startR][startC] = true;
		q.offer(new int[] {startR, startC});
		int cnt=0;
		int size=q.size();
		
		while (!q.isEmpty()) {
			ArrayList<int[]> floodList = new ArrayList();
			// 물 채우기
			for (int r=0; r<R; r++) {
				for (int c=0; c<C; c++) {
					if (map[r][c] != '*') continue;
					for (int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
						if (map[nr][nc]!='.') continue;
						floodList.add(new int[] {nr,nc});
					}
				}
			}
			
			for (int[] pos : floodList) {
				map[pos[0]][pos[1]] = '*';
			}
			
			// 두더지 이동
			for (int i=0; i<size; i++) {
				int[] cur = q.poll();
				
				int curR=cur[0];
				int curC=cur[1];
				
				// 도착지면 종료
				if (curR==dR && curC==dC) {
					return cnt;
				}
				
				// 4방 탐색
				for (int d=0; d<4; d++) {
					int nr = curR+dr[d];
					int nc = curC+dc[d];
					
					if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
					if (visited[nr][nc] || (map[nr][nc]!='.' && map[nr][nc]!='D')) continue;
					
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
			size = q.size();
			cnt+=1;
		}
		
		return -1;
		}
}