import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, k;
	static int[] dp;
	static int[] coin;
	public static void main(String[] args) {
		input();
		
		dynamicProgramming();
		
		print();
	}
	
	private static void print() {
		System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
	}
	
	private static void dynamicProgramming() {
		dp = new int[k+1];
		
		for(int i=1; i<=k; i++) {
			int min = Integer.MAX_VALUE;
			
			for (int j=0; j<n; j++) {
				if (i >= coin[j]) {
					if(dp[i-coin[j]]!=Integer.MAX_VALUE) {
						min = Math.min(min, dp[i-coin[j]] + 1);						
					}
				}
			}
			dp[i] = min;
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		coin = new int[n];
		for (int i=0; i<n; i++) {
			coin[i] = sc.nextInt(); 
		}
		
		Arrays.sort(coin);
	}
}
