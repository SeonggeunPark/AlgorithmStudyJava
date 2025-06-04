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
	static int N, C;
	static int[] houses;
	public static void main(String[] args) throws IOException {	
		init();
		
		Arrays.sort(houses);
		
		int l = 1;
		int r = houses[N-1]-houses[0];
		int result = 0;
		
		while(l <= r) {
			int mid = (l+r)/2;	// 최대 거리
			int count = 1;
			int last = houses[0];
			
			for (int i=1; i<N; i++) {
				if (houses[i] - last >= mid) {
					count += 1;
					last = houses[i];
				}
			}
			
			if (count >= C) {
				result = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		
		System.out.println(result);
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		houses = new int[N];
		for (int i=0; i<N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
	}
}
