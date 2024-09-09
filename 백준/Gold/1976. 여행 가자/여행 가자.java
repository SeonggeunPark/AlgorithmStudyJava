import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[][] city;
	static int[] p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 도시의 수
		n = Integer.parseInt(br.readLine());
		// 여행 계획에 속한 도시들의 수
		m = Integer.parseInt(br.readLine());
		
		city = new int[n+1][n+1];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		p = new int[n+1];
		for (int i = 1; i <=n; i++) {
			p[i] = i;
		}
		
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int px = findSet(i);
				int py = findSet(j);
				if (city[i][j] == 1 && px != py) {
					union(px,py);
				}
			}
		}
		int[] plan = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < plan.length; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for (int i = 1; i < plan.length; i++) {
			if (p[plan[1]]== p[plan[i]] ) {
				cnt++;
			}
		}

		if (cnt == m) {
			System.out.println("YES");
		}else System.out.println("NO");
		
	}
	
	static int findSet(int x) {
		if (x != p[x]) {
			p[x]= findSet(p[x]);
		}
		return p[x];
	}
	
	static void union(int x,int y) {
		p[y] = x;
	}
}
