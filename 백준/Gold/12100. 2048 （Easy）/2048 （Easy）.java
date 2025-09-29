import java.io.*;
import java.util.*;

/*
 *  N : 최대 20
 *  모든 경우의 수 => 4방향 , 5회 = 4^5 = 1,024
 *  브루트포스 가능
 *  
 *  1. dfs로 모든 경우 탐색
 *  2. 시뮬레이션
 *  		-좌: 0행부터, 0열부터
 *  		-우: 0행부터, 3열부터
 *  		-상: 0열부터, 0행부터
 *  		-하: 0열부터, 3행부터
 */
public class Main {
	static final int INF = 1_000_000_000;
	static int N, max;
	static Block[][] board;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static class Block {
		int num;
		boolean merged;
		public Block(int num, boolean merged) {
			super();
			this.num = num;
			this.merged = merged;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new Block[N][N];
		max = 0;
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int n =Integer.parseInt(st.nextToken());
				board[i][j] = new Block(n, false);
//				max = Math.max(n, max);
			}
		}
		dfs(0);
		System.out.println(max);
	}
	private static void dfs(int cnt) {
		if (cnt>=5) {
		    for (int r=0; r<N; r++) {
		        for (int c=0; c<N; c++) {
		            max = Math.max(max, board[r][c].num);
		        }
		    }
		    return;
		}
		// 임시 저장 & merged 초기화
		int[][] origin = new int[N][N];
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				origin[r][c] = board[r][c].num;
				board[r][c].merged = false;
			}
		}
		
		for (int d=0; d<4; d++) {
			// 시뮬레이션
			simulate(d);
//			for (int r=0; r<N; r++) {
//				for (int c=0; c<N; c++) {
//					System.out.print(board[r][c].num+" ");
//				}
//				System.out.println();
//			}
			
			dfs(cnt+1);
			
			// 원상복구
			restore(origin);
		}
	}
	private static void restore(int[][] origin) {
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				board[r][c].num = origin[r][c];
				board[r][c].merged = false;
			}
		}
	}
	private static void simulate(int d) {
		switch (d) {
		case 0: {
			for (int r=0; r<N; r++) {
				out:
					for (int c=1; c<N; c++) {
					int curNum = board[r][c].num;
					if (curNum <= 0) continue;
					// 벽까지 이동
					int nr = r+dr[d];
					int nc = c+dc[d];
					while (nc>=0) {
						// 같은 수고, 아직 안합쳐졌으면 합치기
						if (board[nr][nc].num == curNum && !board[nr][nc].merged) {
							board[nr][nc].num *= 2;
							board[nr][nc].merged = true;
							board[r][c].num=0;
							board[r][c].merged=false;
//							max=Math.max(board[nr][nc].num, max);
							continue out;
						// 다른 수면 그 전 칸에 멈추기
						} else if (board[nr][nc].num > 0) {
							board[r][c].num = 0;
							board[nr-dr[d]][nc-dc[d]].num = curNum;
							board[nr-dr[d]][nc-dc[d]].merged = false;
							continue out;
						// 비어있으면 다음 칸 이동
						} else {
							nr += dr[d];
							nc += dc[d];
						}
					}
					board[r][0].num = curNum;
					board[r][c].num = 0;
				}
			}
			break;
		}
		case 1: {
			for (int r=0; r<N; r++) {
				out:
					for (int c=N-2; c>=0; c--) {
					int curNum = board[r][c].num;
					if (curNum <= 0) continue;
					// 벽까지 이동
					int nr = r+dr[d];
					int nc = c+dc[d];
					while (nc<=N-1) {
						// 같은 수면 합치기
						if (board[nr][nc].num == curNum && !board[nr][nc].merged) {
							board[nr][nc].num *= 2;
							board[nr][nc].merged = true;
							board[r][c].num=0;
							board[r][c].merged=false;
//							max=Math.max(board[nr][nc].num, max);
							continue out;
						// 다른 수면 그 전 칸에 멈추기
						} else if (board[nr][nc].num > 0) {
							board[r][c].num = 0;
							board[nr-dr[d]][nc-dc[d]].num = curNum;
							board[nr-dr[d]][nc-dc[d]].merged = false;
							continue out;
						// 비어있으면 다음 칸 이동
						} else {
							nr += dr[d];
							nc += dc[d];
						}
					}
					board[r][N-1].num = curNum;
					board[r][c].num = 0;
				}
			}
			break;
		}
		case 2: {
			for (int c=0; c<N; c++) {
				out:
					for (int r=1; r<N; r++) {
					int curNum = board[r][c].num;
					if (curNum <= 0) continue;
					// 벽까지 이동
					int nr = r+dr[d];
					int nc = c+dc[d];
					while (nr>=0) {
						// 같은 수면 합치기
						if (board[nr][nc].num == curNum && !board[nr][nc].merged) {
							board[nr][nc].num *= 2;
							board[nr][nc].merged = true;
							board[r][c].num=0;
							board[r][c].merged=false;
//							max=Math.max(board[nr][nc].num, max);
							continue out;
						// 다른 수면 그 전 칸에 멈추기
						} else if (board[nr][nc].num > 0) {
							board[r][c].num = 0;
							board[nr-dr[d]][nc-dc[d]].num = curNum;
							board[nr-dr[d]][nc-dc[d]].merged = false;
							continue out;
						// 비어있으면 다음 칸 이동
						} else {
							nr += dr[d];
							nc += dc[d];
						}
					}
					board[0][c].num = curNum;
					board[r][c].num = 0;
				}
			}
			break;
		}
		case 3: {
			for (int c=0; c<N; c++) {
				out:
					for (int r=N-2; r>=0; r--) {
					int curNum = board[r][c].num;
					if (curNum <= 0) continue;
					// 벽까지 이동
					int nr = r+dr[d];
					int nc = c+dc[d];
					while (nr<=N-1) {
						// 같은 수면 합치기
						if (board[nr][nc].num == curNum && !board[nr][nc].merged) {
							board[nr][nc].num *= 2;
							board[nr][nc].merged = true;
							board[r][c].num=0;
							board[r][c].merged=false;
//							max=Math.max(board[nr][nc].num, max);
							continue out;
						// 다른 수면 그 전 칸에 멈추기
						} else if (board[nr][nc].num > 0) {
							board[r][c].num = 0;
							board[nr-dr[d]][nc-dc[d]].num = curNum;
							board[nr-dr[d]][nc-dc[d]].merged = false;
							continue out;
						// 비어있으면 다음 칸 이동
						} else {
							nr += dr[d];
							nc += dc[d];
						}
					}
					board[N-1][c].num = curNum;
					board[r][c].num = 0;
				}
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + d);
		}
	}
}