import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// 가방 제한무게 오름차순 정렬
	// 해당 가방에 넣을 수 있는 것 중 가장 비싼 보석 넣기
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static int N, M, V, K;
	static long sum;
	static int[] bags;
//	static ArrayList<int[]> jewels;
	static int[][] jewels;
	static class Jewel implements Comparable<Jewel> {
		int m, v;
		public Jewel(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}
		@Override
		public int compareTo(Main.Jewel o) {
			if (this.v==o.v) {
				return this.m-o.m;
			}
			return o.v-this.v;
		}
	}
	static boolean[][] visited, directions; // false: 가로, true: 세로
	public static void main(String[] args) throws IOException {
		init();
		Arrays.sort(jewels, (o1, o2) -> o1[0] - o2[0]);
		Arrays.sort(bags);
		PriorityQueue<Jewel> q = new PriorityQueue<>();
		
		int jIdx = 0;
		for (int i=0; i<K; i++) {
			int curM = bags[i];
			while(jIdx < jewels.length) {
				if (jewels[jIdx][0] <= curM) {
					q.offer(new Jewel(jewels[jIdx][0], jewels[jIdx][1]));
					jIdx+=1;
				} else {
					break;
				}
			}
			if (q.isEmpty()) {
				continue;
			}
			sum += q.poll().v;
		}
		
		System.out.println(sum);
		
	}
	private static void init() throws IOException {
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		jewels = new int[N][2];
		bags = new int[K];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels[i][0] = m;
			jewels[i][1] = v;
		}
		for (int i=0; i<K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		sum = 0;
	}
}