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
	static int[] p;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 본인이 속한 집합의 최상위 노드를 가리키는 배열
		p = new int[n+1];
		for (int i=0; i<=n; i++) {
			p[i]=i;
		} // 맨 처음엔 각 노드 자신이 최상위노드
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			if (op == 0) {
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			} else {
				if (isUnion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
					sb.append("YES\n");
					continue;
				}
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
	}
	private static boolean isUnion(int a, int b) {
		return find(a) == find(b);
	}
	private static void union(int a, int b) {
		p[find(a)] = find(b);
	}
	private static int find(int a) {
		if (p[a] == a) {
			return a;
		}
		// 최상위 부모를 찾은 후 최상위 부모를 자신의 부모로 갱신
		int parent = find(p[a]);
		p[a] = parent;
		return parent;
	}
}
