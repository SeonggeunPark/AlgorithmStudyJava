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
	static int[] arr;
	public static void main(String[] args) throws IOException {	
		init();
		
		for (int i=M; i>0; i--) {
			if (M-i+1 > N) break;
			
			int price = arr[i];
			sum = price*(M-i+1);
			
			if (max < sum) {
				max = sum;
				maxPrice = price;
			}
			max = Math.max(max, sum);
		}
		
		sb.append(maxPrice).append(' ').append(max);
		System.out.println(sb);
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = 0;
		max = 0;
		maxPrice = 0;
		arr = new int[M+1];
		for (int i=1; i<=M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
	}
}
