import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		for (int c=1; c<=C; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int sum = 0;
			int count = 0;
			for (int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			double avg = (double)sum / n;
			for (int i=0; i<n; i++) {
				if (avg < arr[i]) {
					count += 1;
				}
			}
			System.out.printf("%.3f%%\n", (double) count / n * 100);
//			System.out.println(Math.round((double) count/n * 100000)/(double)1000);
		}
	}
}
