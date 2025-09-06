import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] p, rank;
	static boolean flag;
	static boolean[] visited;
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		init();

//		System.out.println(Arrays.toString(p));
//		System.out.println(Arrays.toString(rank));
		// rank가 5 이상일 때만 수색
		for (int i=0; i<N; i++) {
			if (flag) break;
			if (rank[find(i)] < 5) continue;
			Arrays.fill(visited, false);
			dfs(i,1);
		}
		
		System.out.println(flag ? 1 : 0);
	}

    // 백트래킹 DFS: 깊이 5 도달하면 성공
    private static void dfs(int u, int depth) {
        if (flag) return;
        if (depth >= 5) {
            flag = true;
            return;
        }
        visited[u] = true;
        for (int v : adjList[u]) {
            if (!visited[v]) {
                dfs(v, depth + 1);
                if (flag) return;
            }
        }
        visited[u] = false;
    }

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
			rank[i] = 1;
		}
		adjList = new ArrayList[N];
		for (int i=0; i<N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			union(s, e);

			adjList[s].add(e);
			adjList[e].add(s);
		}
		visited = new boolean[N];
	}

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px != py) {
			p[px] = py;
			rank[py] += rank[px];
		}
	}

	private static int find(int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x]= find(p[x]);
	}
}