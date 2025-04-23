import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int originNum = N;
		int cnt = 0;
		int ans = 0;
		while(N/10 > 0) {
			ans += 9*Math.pow(10, cnt)*(cnt+1);
			N /= 10;
			cnt += 1;
		}
		
		ans += (originNum - Math.pow(10, cnt) + 1)*(cnt+1);
		
		System.out.println(ans);
	}
}