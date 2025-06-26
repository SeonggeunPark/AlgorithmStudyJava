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
	static int N, M;
	static int[] arr, pick;
	public static void main(String[] args) throws IOException {	
		init();
		
		permutate(0, 0);
		
		System.out.println(sb);
	}
	// n개의 수 중 r개를 선택
	// 이전에 선택한 수보다 같거나 큰 수
	private static void permutate(int aIdx, int pIdx) {
		if (pIdx >= M) {
			for (int num : pick) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i=aIdx; i<N; i++) {
			pick[pIdx] = arr[i];
			permutate(i, pIdx+1);
		}
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		pick = new int[M];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
	}
}
