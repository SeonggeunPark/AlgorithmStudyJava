import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] map;
	public static void main(String[] args) throws Exception, IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new boolean[N][N];
		
		// (N/3)*(N/3)짜리 타일의 0행 0열
		DFS(0, 0, N); 
		
		StringBuilder sb = new StringBuilder();
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (map[r][c])
				sb.append('*');
				else 
				sb.append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	private static void DFS(int i, int j, int n) {
		if (n<=3) {
			for (int r=0; r<3; r++) {
				for (int c=0; c<3; c++) {
					if (r==1 && c==1) continue;
					map[r+i][c+j] = true;
				}
			}
			return;
		}
		
		n /= 3;
		
		for (int r=0; r<3; r++) {
			for (int c=0; c<3; c++) {
				if (r==1 && c==1) continue;
				DFS(r*n+i, c*n+j, n);
			}
		}
	}
}
