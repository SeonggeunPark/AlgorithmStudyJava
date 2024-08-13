import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		int cnt = 0;
		cnt++;
		for (int i=0; i<N; i++) {
			char  c = arr[i];
			
			if (c == 'S') {
				cnt++;
			} else {
				cnt++;
				i+=1;
			} 
		}
		
		System.out.println(Math.min(cnt, N));
	}
}
