import java.io.*;
import java.util.*;

public class Main {
	static final long INF = Long.MAX_VALUE;
	static char[] A, B;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		dp = new int[A.length+1][B.length+1];
		
		for (int i=1; i<A.length+1; i++) {
			for (int j=1; j<B.length+1; j++) {
				if(A[i-1]!=B[j-1]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				} else {
					dp[i][j] = dp[i-1][j-1]+1;
				}
			}
		}
		char[] res = new char[dp[A.length][B.length]];
		int aIdx = A.length; int bIdx = B.length; int rIdx=dp[A.length][B.length]-1;
		while(aIdx>=1 && bIdx>=1) {
			if (A[aIdx-1]==B[bIdx-1]) {
				res[rIdx--]=A[aIdx-1];
				aIdx-=1;
				bIdx-=1;
				continue;
			} 
			if (dp[aIdx-1][bIdx]>dp[aIdx][bIdx-1]) {
				aIdx-=1;
			} else {
				bIdx-=1;
			}
		}
		
		System.out.println(dp[A.length][B.length]);
		for (int i=0; i<res.length; i++) {
			System.out.print(res[i]);
		}
	}
}