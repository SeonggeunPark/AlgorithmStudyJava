import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();;
	static int N, T;
	static long sum;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			sum = 0;
			arr = new int[N];
			for (int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
					int a = arr[i];
					int b = arr[j];
					
					sum += gcd(a, b);
				}
			}
			
			sb.append(sum).append('\n');
			
		}
		
		System.out.println(sb);
	}

	private static int gcd(int a, int b) {
		if (b==0) return a;
		return gcd(b, a%b);
	}

	static void init() throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
	}
}