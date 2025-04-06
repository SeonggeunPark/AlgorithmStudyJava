import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] sum = new int[N];
		
		st = new StringTokenizer(br.readLine());
		sum[0] = Integer.parseInt(st.nextToken());
		for (int i=1; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1]+num;
		}
		
		int i=-1;
		int j=i+k;
		int max = sum[j];
		while(j<N-1) {
			max = Math.max(max, sum[++j]-sum[++i]);
		}
		
		System.out.println(max);
	}
}
