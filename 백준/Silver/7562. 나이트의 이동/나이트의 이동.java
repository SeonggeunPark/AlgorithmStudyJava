import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int currR, currC, targetR, targetC, min, I;
	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			I = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			currR = Integer.parseInt(st.nextToken());
			currC = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			targetR = Integer.parseInt(st.nextToken());
			targetC = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;

			BFS(currR, currC);

			System.out.println(min);
		}
	}

	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[I][I];

		visited[r][c] = true;
		q.add(new int[] { r, c });
		int size = 1;
		int cnt = 0;

		while (!q.isEmpty()) {

			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();

				if (curr[0] == targetR && curr[1] == targetC) {
					min = cnt;
					return;
				}
				
				for (int dir=0; dir<8; dir++) {
					int nr = curr[0] + dr[dir];
					int nc = curr[1] + dc[dir];
					
					if (nr<0 || nc<0 || nr>=I || nc>=I || visited[nr][nc])
						continue;
					
					q.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
			
			size = q.size();
			cnt += 1;
		}
	}
}