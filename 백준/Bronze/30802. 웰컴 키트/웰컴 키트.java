import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] sizes = new int[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<6; i++) {
			sizes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int t = 0;
		for (int num : sizes) {
			if (num%T == 0) {
				t += num/T;
			} else {
				t += num/T+1;
			}
		}
		sb.append(t).append('\n');
		sb.append(N/P).append(' ').append(N%P);
		
		System.out.println(sb);
		
		
	}
}