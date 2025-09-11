import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 도시 수
		int M = sc.nextInt();	// 계획 포함 도시 수
		// union-find 전략
		int[] p = new int[N+1];
		for (int i=1; i<=N; i++) {
			p[i] = i;
		}
		// 연결된 길끼리 union
		int[][] adjArr = new int[N+1][N+1];
		for (int s=1; s<=N; s++) {
			for (int e=1; e<=N; e++) {
				adjArr[s][e] = sc.nextInt();
				
				if (adjArr[s][e] == 0) continue;
				union(s, e, p);
			}
		}
		int[] route = new int[M];
		for (int i=0; i<M; i++) {
			route[i] = sc.nextInt();
		}
		
		boolean isValid = true;
		for (int i=1; i<route.length; i++) {
			int s = route[i-1];
			int e = route[i];
			
			if (find(s, p) != find(e, p)) {
				isValid = false;
				break;
			}
		}
		
		System.out.println(isValid ? "YES" : "NO");
	}

	private static void union(int x, int y, int[] p) {
		int px = find(x, p);
		int py = find(y, p);
		if (px == py) return;
		
		p[px] = py;
	}

	private static int find(int x, int[] p) {
		if (p[x] == x) return x;
		return p[x] = find(p[x], p);
	}
}