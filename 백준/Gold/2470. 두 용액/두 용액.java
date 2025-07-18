import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] liquids;
	static int N, min;
	public static void main(String[] args) throws IOException {
		init();
		
		Arrays.sort(liquids);
		
		int l=0;
		int r=N-1;
		int L = l;
		int R = r;
		
		while(l<r) {
			int sum = liquids[l] + liquids[r];
			
			if (Math.abs(sum) < min) {
				L = l;
				R = r;
				min = Math.abs(sum);
			}
			
			if (sum < 0) {
				l+=1;
			}
			else if (sum > 0) {
				r-=1;
			}
			else {
				break;
			}
		}
		
		System.out.println(liquids[L] +" "+ liquids[R]);
	}
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		liquids = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			liquids[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
	}
}
