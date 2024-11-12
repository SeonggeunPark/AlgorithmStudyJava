import java.util.Scanner;

public class Main {
	/*
	 * N개와 M개의 사이트를 겹치지 않고 각각 연결하는 경우의 수는
	 * 중복을 허용하지 않고 M개 중 N개를 고르는 모든 경우의 수와 같음
	 * 따라서 정답은 nCm 이다. 
	 * 다만 테스트케이스가 커지고 n과 m 값이 커지면 중복 계산이 많아져
	 * 비효율적이므로, 이미 계산한 값은 배열에 저장해둠으로써 중복 계산 해결
	 */
	static int[][] memo = new int[31][31];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(Combination(M, N));
		}
	}

	private static int Combination(int m, int n) {
		if (memo[m][n]>0) {
			return memo[m][n];
		}
		if (n<=0 || m==n) {
			memo[m][n] = 1;
			return 1;
		}
		if (n<=1) {
			memo[m][n] = m;
			return m;
		}
		memo[m][n] = Combination(m-1, n-1)+Combination(m-1,n);
		return memo[m][n];
	}
}
