import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] S, pick;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		pick = new int[6];
		sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) return;
			
			sb.setLength(0);
			
			S = new int[k];
			for (int i=0; i<k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			
			System.out.println(sb);
		}
	}
	private static void combination(int sidx, int pidx) {
		if (pidx >= 6) {
			for (int num : pick) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		if (sidx >= k) {
			return;
		}
		
		pick[pidx] = S[sidx];
		combination(sidx+1, pidx+1);
		combination(sidx+1, pidx);
	}

}