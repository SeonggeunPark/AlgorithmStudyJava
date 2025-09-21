import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] p = new int[N+1];
		for (int i=1; i<=N; i++) {
			p[i] = i;
		}
		int[][] edges = new int[M][3];
		for (int i=0; i<M; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		/// 간선 저렴한 순으로 정렬
		Arrays.sort(edges, (o1, o2) -> {
			return o1[2]-o2[2];
		});
		
		int sum = 0;
		ArrayList<Integer> pickList = new ArrayList();
		// 저렴한 순으로 모두 연결될 때까지
		for (int i=0; i<M; i++) {
			if (pickList.size()>=N-2) break;
			int s = edges[i][0];
			int e = edges[i][1];
			int w = edges[i][2];
			
			int ps = find(s, p);
			int pe = find(e, p);
			
			if (ps==pe) continue;
			
			union(s, e, p);
			sum += w;
			pickList.add(i);
			
		}
		
		System.out.println(sum);
	}
	private static int find(int x, int[] p) {
		if (p[x]==x) return x;
		return p[x]=find(p[x], p);
	}
	private static void union(int x, int y, int[] p) {
		p[find(x, p)] = find(y, p);
	}
}