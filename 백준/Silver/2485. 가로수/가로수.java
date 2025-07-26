import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, ans, tmpGcd;
	static int[] trees;
	static int[] dists;

	public static void main(String[] args) throws IOException {
		init();
		
		// 각 간격의 최대공약수를 구해야 함.
		tmpGcd = gcd(dists[0], dists[1]);
		for (int i=2; i<N-1; i++) {
			tmpGcd = gcd(tmpGcd, dists[2]);
			if (tmpGcd == 1) break;
		}
		
		for (int n : dists) {
			ans += n/tmpGcd - 1;
		}
		
		System.out.println(ans);
	}
	private static int gcd(int i, int j) {
		
		int tmp = i;
		i = j;
		j = tmp%j;
		
		if (j == 0) return i;
		else return gcd(i,j);
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		trees = new int[N];
		dists = new int[N-1];
		for (int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(br.readLine());
		}
		for (int i=0; i<N-1; i++) {
			dists[i] = trees[i+1]-trees[i];
		}
		
		ans = 0;
	}
}
