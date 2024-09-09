import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Set {
		int signal;
		int a;
		int b;

		public Set(int signal, int a, int b) {
			super();
			this.signal = signal;
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Set [signal=" + signal + ", a=" + a + ", b=" + b + "]";
		}

	}

	static int n, m;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Set[] set = new Set[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sig = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			set[i] = new Set(sig, a, b);
		}
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			
			int psig = set[i].signal;
			int px = findSet(set[i].a);
			int py = findSet(set[i].b);
			
			if (psig == 0) {
				union(px,py);
				
			}else if(psig == 1) {
				if (px == py) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	
	static int findSet(int x) {
		if (x!= p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = x;
	}
	
}
