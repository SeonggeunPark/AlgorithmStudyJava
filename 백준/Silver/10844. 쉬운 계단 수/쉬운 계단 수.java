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
/*
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		// N자리 계단수 중 끝자리가 0~9인 수의 개수를 각각 저장하는 배열
		long[][] dp = new long[N+1][10];
		
		// 1자리 계단수의 경우의 수 각 초기화(1~9 각 1개씩)
		for (int j=1; j<=9; j++) {
			dp[1][j] = 1;
		}
		
		// 2자리 계딴수부터 작업 시작
		for (int i=2; i<=N; i++) {
			for (int j=0; j<=9; j++) {
				if (j==0) {
					dp[i][j] = dp[i-1][1];
					continue;
				}
				if (j==9) {
					dp[i][j] = dp[i-1][8];
					continue;
				}
				
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
			}
		}
		
		long ans = 0;
		for (long n : dp[N]) {
			ans += n;
		}
		
		System.out.println(ans%1000000000);
	}
}
