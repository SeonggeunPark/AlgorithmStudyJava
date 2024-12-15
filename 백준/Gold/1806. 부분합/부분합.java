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
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int minL = Integer.MAX_VALUE;
		int currSum = 0;
		
		while(end <= N+1 && start <= N) {
			if (currSum < S) {
				currSum += arr[end++];
			}
			else {
				minL = Math.min(minL,  end-start);
				currSum -= arr[start++];
			}
		}
		
		if (minL == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(minL);
		}
	}
}
