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

import org.w3c.dom.Node;

public class Main {
	static class Node implements Comparable<Node> {
		int val, idx;
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public Node(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}
		@Override
		public int compareTo(Node o) {
			return o.val - this.val;
		}
	}
	static int[] A, B;
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = 0;	// 총합
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		PriorityQueue<Node> pq = new PriorityQueue<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			pq.add(new Node(Integer.parseInt(st.nextToken()), i));
		}
		
		// 구현
		// A배열 오름차순 정렬
		Arrays.sort(A);
		for (int i=0; i<N; i++) {
			S += A[i]*pq.poll().val;
		}
		
		// 출력
		System.out.println(S);
	}
}
