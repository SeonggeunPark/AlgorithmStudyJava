import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int  T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] snack = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum;
			int max = -1;
			
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
					sum = snack[i]+snack[j];
					if (sum > M) continue;
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
}
