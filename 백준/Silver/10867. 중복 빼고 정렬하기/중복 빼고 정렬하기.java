import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static StringBuilder sb;
	static int N;
	static boolean[] visited;
	static int[] arr;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		
		for (int n : list) {
			sb.append(n).append(' ');
		}
		
		System.out.println(sb);
	}

	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 정점 수
		visited = new boolean[2001];
		arr = new int[N];
		list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (!visited[n+1000]) {
				visited[n+1000] = true;
				list.add(n);
			}
		}
		
		Collections.sort(list);
	}
}