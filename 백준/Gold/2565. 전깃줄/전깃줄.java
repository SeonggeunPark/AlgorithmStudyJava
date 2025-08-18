import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Wire[] wires;
	static int[] lis;
	static class Wire implements Comparable<Wire> {
		int a;
		int b;
		public Wire(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Main.Wire o) {
			return this.a - o.a;
		}
		
	}
	public static void main(String[] args) throws IOException {
		init();
		
		Arrays.sort(wires);
		int max = wires[0].b;
		int maxIdx = 0;
		lis[0] = max;
		out:
		for (int i=1; i<N; i++) {
			if (max < wires[i].b) {
				lis[++maxIdx] = wires[i].b;
				max = wires[i].b;
			} else if (max > wires[i].b) {
				for (int j=maxIdx; j>=0; j--) {
					if (lis[j] < wires[i].b) {
						lis[j+1] = wires[i].b;
						max = Math.min(max, lis[maxIdx]);
						continue out;
					} 
				}
				lis[0] = wires[i].b;
			}
		}
		System.out.println(N-maxIdx-1);
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		wires = new Wire[N];
		lis = new int[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wires[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
}
