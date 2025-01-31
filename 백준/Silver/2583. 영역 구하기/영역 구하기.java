import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int N, M, K, cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] area;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;

		pq = new PriorityQueue<>();
		
		visited = new boolean[M][N];
//		map = new boolean[M+1][N+1];
		
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			cover(x1, y1, x2, y2);
		}
		
		for (int r=0; r<M; r++) {
			for (int c=0; c<N; c++) {
				if (visited[r][c]) continue;
//				for (int R=0; R<M; R++) {
//					System.out.println(Arrays.toString(visited[R]));
//				}
				BFS(r, c);
				cnt += 1;
			}
		}
		
		System.out.println(cnt);
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append(' ');
		}
		System.out.println(sb);
	}
	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		int area = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int dir = 0; dir <=3; dir++) {
				int nr = curr[0]+dr[dir];
				int nc = curr[1]+dc[dir];
				
				if (nr<0 || nr>=M || nc<0 || nc>=N) continue;
				if (visited[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
				area+=1;
			}
		}
		
		pq.add(area);
	}
	static void cover(int x1, int y1, int x2, int y2) {
		for (int r=x1; r<x2; r++) {
			for (int c=y1; c<y2; c++) {
				visited[r][c] = true;
			}
		}
	}
	
}