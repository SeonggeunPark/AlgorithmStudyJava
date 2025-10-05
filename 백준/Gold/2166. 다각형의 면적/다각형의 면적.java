import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long[] x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		x = new long[N+1];
		y = new long[N+1];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Long.parseLong(st.nextToken());
			y[i] = Long.parseLong(st.nextToken());
		}
		x[N] = x[0];
		y[N] = y[0];
		
		long sum =0;
		for (int i=0; i<N; i++) {
			sum+=(x[i]*y[i+1]-y[i]*x[i+1]);
		}
		double ans = Math.abs(sum)/2.0;
		System.out.printf("%.1f%n", ans);
	}
}