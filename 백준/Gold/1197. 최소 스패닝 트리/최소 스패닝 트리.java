import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	static int V, E, min;
	static int[] p;
	static class Edge implements Comparable<Edge>{
		int s, e, w;
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		min = 0;
		p = new int[V+1];
		for (int i=1; i<=V; i++) {
			p[i] = i;
		}
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int cnt = 0; 
		while(cnt < V-1 && !pq.isEmpty()) {
			Edge curr = pq.poll();
			int s = curr.s;
			int e = curr.e;
			int w = curr.w;
			
			// 사이클인지 확인
			if (find(s) == find(e)) continue;
			
			// 간선 채택
			union(s, e);
			
			cnt += 1;
			min += w;
		}
		
		System.out.println(min);
	}
	static void union(int a, int b) {
		p[find(a)] = find(b);
	}
	static int find(int a) {
	    while (a != p[a]) {
	        p[a] = p[p[a]]; // path compression
	        a = p[a];
	    }
	    return a;
	}
}
