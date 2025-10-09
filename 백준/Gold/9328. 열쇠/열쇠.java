import java.io.*;
import java.util.*;

public class Main {
	static int R, C, ans;
	static int diff = 'a'-'A';
	static char[][] map;
	static ArrayList<Door>[] doors;
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};
	static final int INF = Integer.MAX_VALUE;
	static class Door {
		int r;
		int c;
		public Door(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			ans = 0;
			StringTokenizer st= new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for (int r=0; r<R; r++) {
				map[r] = br.readLine().toCharArray();
			}
			char[ ] keys = br.readLine().toCharArray();
			doors = new ArrayList[26];
			for (int i=0; i<26; i++) {
				doors[i] = new ArrayList<>();
			}
			for (int r=0; r<R; r++) {
				for (int c=0; c<C ; c++) {
					char cur = map[r][c];
					if(cur>='A' && cur<='Z') {
						doors[cur-'A'].add(new Door(r, c)); 
					}
				}
			}
			// 키 갖고 있는 문열기(빈땅으로 전환)
			if (keys[0] != '0') {
				for (char key: keys ) {
					key -= 'a';
					for (Door d : doors[key]) {
						map[d.r][d.c]= '.'; 
					}
				}
			}
//			boolean[][] visited= new boolean[R][C];
			boolean changed = true;
			while (changed) {
				changed = false;
				for (int r=0; r<R; r++) {
					for (int c=0; c<C ; c++) {
						if (r<=0 || r>=R-1 || c<=0 || c>=C-1) {
							if (map[r][c] == '$') {
								ans += 1;
								map[r][c] = '.';
							}
							if (map[r][c] >= 'a' && map[r][c] <= 'z') {
							    int key = map[r][c] - 'a';
							    map[r][c] = '.';
							    for (Door d : doors[key]) map[d.r][d.c] = '.';
							    changed = true;
							}
							if (map[r][c] != '.') continue;
							changed |= search(r,c);
//							System.out.println();
//							for (int i=0; i<R; i++) {
//								for (int j=0; j<C; j++) {
//									System.out.print(map[i][j]);
//								}
//								System.out.println();
//							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	private static boolean search(int startR, int startC) {
		boolean anyChange = false;
		// BFS
		Queue<Character> keyQ = new ArrayDeque<Character>();
		int before = ans;
		BFS(startR, startC, keyQ);
	    if (ans > before) anyChange = true;
	    
		// 열쇠 먹었으면 뚫고 다시 BFS
		while (!keyQ.isEmpty()) {
			boolean openedDoor = false;
			while (!keyQ.isEmpty()) {
				char key = keyQ.poll();
				key -= 'a';
				for (Door d : doors[key]) {
					map[d.r][d.c]= '.'; 
					openedDoor = true;
                    anyChange = true;
				}
			}
			if (openedDoor) {
	            int before2 = ans;
	            BFS(startR, startC, keyQ);
	            if (ans > before2) anyChange = true; // 추가 문서 먹음
	        }
		}
		return anyChange;
	}

	private static void BFS(int startR, int startC, Queue<Character> keyQ) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[R][C];
		visited[startR][startC] = true;
		q.offer(new int[] {startR, startC});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
//			System.out.println("r, c => "+r+", "+c);
			
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
//				System.out.println("nr, nc => "+nr+", "+nc);
				
				if (nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc]) continue;
				// 문일 때
				if (map[nr][nc] == '*' || (map[nr][nc] >='A' && map[nr][nc] <= 'Z')) continue;
				// 열쇠일 때
				if (map[nr][nc]>='a' && map[nr][nc]<='z') {
					keyQ.offer(map[nr][nc]);
					map[nr][nc] = '.';
				}
				// 문서일 때
				if (map[nr][nc]=='$') {
					ans+=1;
					map[nr][nc] = '.';
				}
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
	}
}