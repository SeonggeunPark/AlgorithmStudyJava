import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int idx;
		int val;
		int rank;
		public Node() {
			// TODO Auto-generated constructor stub
		}
//		public Node(int idx, int val) {
//			super();
//			this.idx = idx;
//			this.val = val;
//		}
		
		public Node(int idx, int val, int rank) {
			super();
			this.idx = idx;
			this.val = val;
			this.rank = rank;
		}
		@Override
		public String toString() {
			return "Node [idx=" + idx + ", val=" + val + "]";
		}
		@Override
		public int compareTo(Node o) {
			return this.val-o.val;
		}
		
	}
	static int N;
	static int[] arr;
	static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		
//		int[] arr = new int[N];
		int[] rank = new int[N];
		Node[] nodes = new Node[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int val = Integer.parseInt(st.nextToken());
//			arr[i] = val;
			nodes[i]=new Node(i, val, 0);
		}
		
		Arrays.sort(nodes);
		
		for (int i=1; i<N; i++) {
			if (nodes[i].val == nodes[i-1].val) {
				rank[i] = rank[i-1];
				nodes[i].rank = rank[i];
			} else {
				rank[i] = rank[i-1]+1;
				nodes[i].rank = rank[i];
			}
		}
		
		Arrays.sort(nodes, new Comparator<Node>() {
		    @Override
		    public int compare(Node o1, Node o2) {
		    	// 오름차순
		        return o1.idx - o2.idx;
		    }
		});
		
		for (Node node : nodes) {
			sb.append(node.rank).append(' ');
		}
		System.out.println(sb);
	}
}
