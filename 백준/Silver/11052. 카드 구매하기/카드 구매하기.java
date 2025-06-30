import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static int[] p, dp;
	
	public static void main(String[] args) throws IOException {
		init();
		
		for (int i=2; i<=N; i++) {
			dp[i] = p[i];
			
			for (int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[j]+p[i-j]);
			}
			
			dp[i] = dp[i];
		}
		
		System.out.println(dp[N]);
	}
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		p = new int[N+1];
		dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = p[1];
	}
}