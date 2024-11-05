import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N, M;
	static int[] arr, tmp;
	static boolean[] visited;
	static StringBuilder sb;
	static Set<String> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		visited = new boolean[N];
		tmp = new int[M];
		set = new HashSet<>();
		
		DFS(0);
	}
	
	private static void DFS(int cnt) {
		if (cnt == M) {
			StringBuilder combination = new StringBuilder();
			for (int i = 0; i < M; i++) {
				combination.append(tmp[i]).append(" ");
			}
			
			String comboString = combination.toString();
			if (set.contains(comboString)) return;
			set.add(comboString);
			
			// 출력
			System.out.println(comboString);
			return;
		}
		
		int lastUsed = -1;
		for (int i = 0; i < N; i++) {
			if (visited[i] || arr[i] == lastUsed) continue;
			tmp[cnt] = arr[i];
			visited[i] = true;
			lastUsed = arr[i];
			DFS(cnt + 1);
			visited[i] = false;
		}
	}
}
