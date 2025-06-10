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
	static int N, M, sum, max, maxPrice;
	static Problem[] arr;
	static int[] ans;
	static class Problem implements Comparable<Problem>{
		
		int num;
		int score;
		
		public Problem(int num, int score) {
			super();
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Problem o) {
			return this.score - o.score;
		}
		
	}
	public static void main(String[] args) throws IOException {	
		init();
		
		for (int i=7; i>2; i--) {
			ans[i-3] = arr[i].num;
			sum += arr[i].score;
		}
		
		Arrays.sort(ans);
		
		sb.append(sum).append('\n');
		for (int i=0; i<5; i++) {
			sb.append(ans[i]).append(' ');
		}
		System.out.println(sb);
	}
	
	static void init() throws IOException {
		arr = new Problem[8];
		ans = new int[5];
		sum = 0;
		for (int i=0; i<8; i++) {
			arr[i] = new Problem(i+1, Integer.parseInt(br.readLine()));
		}
		
		Arrays.sort(arr);
	}
}
