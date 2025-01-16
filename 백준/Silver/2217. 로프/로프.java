import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int currR, currC, targetR, targetC, min, I;
	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] ropes = new int[N];
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ropes);
		
		int max = N*ropes[0];
		for (int i=1; i<N; i++) {
			max = Math.max(max, ropes[i]*(N-i));
		}
		System.out.println(max);
	}

}