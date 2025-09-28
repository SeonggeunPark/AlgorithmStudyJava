import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 1_000_000_000;
	static int N, M;
	static int[] p;
	static int[] r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N];
		r = new int[N];
		for (int i=0; i<N; i++) {
			p[i]=i;
			r[i]=1;
		}
		int[][] inputs = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			inputs[i][0]=s;
			inputs[i][1]=e;
		}
		int ans = 0;
		for (int i=0; i<M; i++) {
			int x = inputs[i][0];
			int y = inputs[i][1];
			int px = find(x);
			int py = find(y);
			
			if (px==py) {
				ans=i+1;
				break;
			}
			
			union(x,y);
		}
		
		System.out.println(ans);
	}

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (r[px] > r[py]) {
			p[py] = px;
		} else {
			p[px] = py;
		}
	}

	private static int find(int x) {
		if (p[x]==x) return x;
		int px = find(p[x]);
		r[p[x]]-=1;
		p[x] = px;
		r[px]+=1;
		return px;
	}
}
