import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N, M, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		K = Integer.parseInt(br.readLine());
		for (int i=0 ; i <K; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(cal(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1)).append('\n');
		}
		
		System.out.println(sb);
	}
	private static int cal(int i, int j, int x, int y) {
		int sum = 0;
		for (int r=i; r<=x; r++) {
			for (int c=j; c<=y; c++) {
				sum += arr[r][c];
			}
		}
		
		return sum;
	}
}