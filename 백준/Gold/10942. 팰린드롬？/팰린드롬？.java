import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] nums = new int[N+1];
		for (int i=1; i<=N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		int[][] questions = new int[M][2];
		for (int i=0; i<M; i++) {
			questions[i][0] = sc.nextInt();
			questions[i][1] = sc.nextInt();
		}
		boolean[][] dp = new boolean[N+1][N+1]; // a부터 b까지 팰린드롬인지
		for (int i=1; i<=N; i++) {
			dp[i][i] = true;
			dp[i-1][i] = nums[i-1]==nums[i];
		}
		for (int len=2; len<=N; len++) {
			for (int i=1; i<=N-len; i++) {
				dp[i][i+len] = dp[i+1][i+len-1] && nums[i]==nums[i+len];
			}
		}
		
		for (int[] q : questions) {
			int s = q[0];
			int e = q[1];
			sb.append(dp[s][e]?1:0).append('\n');
		}
		
		System.out.println(sb);
	}
	static int check(int s, int e, int[] nums, int[][] dp) {
		while (s<=e) {
			if (nums[s] != nums[e]) return 0;
			s+=1;
			e-=1;
		}
		return 1;
	}
}