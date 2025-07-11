import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int n, ans;
	static int[] scores;
	public static void main(String[] args) throws IOException {
		init();
		
		Arrays.sort(scores);
		
		int except = (int) Math.round((float) n * 0.15);
		int sum = 0;
		for (int i=except; i<n-except; i++) {
			sum += scores[i];
		}
		
		System.out.println(Math.round((float)sum/(n-2*except)));
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		scores = new int[n];
		
		for (int i=0; i<n; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		} 
	}
}
