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
		int t = Integer.parseInt(br.readLine());
		int[][] input = new int[t][2];

		int maxk = 1;
		int maxn = 1;
		for (int i = 0; i < t; i++) {
			input[i][0] = Integer.parseInt(br.readLine());
			input[i][1] = Integer.parseInt(br.readLine());

			maxk = Math.max(maxk, input[i][0]);
			maxn = Math.max(maxn, input[i][1]);
		}

		int[][] apartment = new int[maxk+1][maxn + 1];
		for (int c = 1; c <= maxn; c++) {
			for (int r = 0; r <= maxk; r++) {
				if (r == 0) {
					apartment[r][c] = c;
				} else {
					apartment[r][c] = apartment[r - 1][c] + apartment[r][c - 1];
				}
			}
		}
		
		for (int i=0; i<t; i++) {
			System.out.println(apartment[input[i][0]][input[i][1]]);
		}
	}
}