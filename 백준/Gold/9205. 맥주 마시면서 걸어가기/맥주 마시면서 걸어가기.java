import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] stores;
	static boolean visited[];
	static int[] home;
	static int[] festival;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=t; tc++) {
			
			init(br);
			if (calDist(home[0], home[1], festival[0], festival[1]) <= 1000) {
				System.out.println("happy");
				continue;
			}
			
			System.out.println(BFS());
			
		}
	}
	public static class Node implements Comparable<Node>{
		int storeNum;
		int distFromMe;
		int distFromDestination;
		public Node() {}
		public Node(int storeNum, int distFromMe, int distFromDestination) {
			super();
			this.storeNum = storeNum;
			this.distFromMe = distFromMe;
			this.distFromDestination = distFromDestination;
		}
		@Override
		public int compareTo(Node o) {
			if (this.distFromDestination == o.distFromDestination)
				return this.distFromMe - o.distFromMe;
			return this.distFromDestination - o.distFromDestination;
		}
	}
	private static String BFS() {
		pq.clear();
		visited = new boolean[n];
		
		findToGo(home[0], home[1]);
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if (calDist(stores[curr.storeNum][0], stores[curr.storeNum][1], festival[0], festival[1]) <= 1000) {
				return "happy";
			}
			
			findToGo(stores[curr.storeNum][0], stores[curr.storeNum][1]);
			
		}
		
		return "sad";
	}
	private static void findToGo(int currR, int currC) {
		for (int i=0; i<n; i++) {
			if (visited[i]) continue;
			if (calDist(currR, currC, stores[i][0], stores[i][1]) <= 1000) {
				pq.offer(new Node(i, calDist(currR, currC, stores[i][0], stores[i][1]), calDist(stores[i][0], stores[i][1], festival[0], festival[1])));
				visited[i] = true;
			}
		}
	}
	private static int calDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
	private static void init(BufferedReader br) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		stores = new int[n][2];
		home = new int[2];
		festival = new int[2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		home[0] = Integer.parseInt(st.nextToken());
		home[1] = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			stores[i][0] = Integer.parseInt(st.nextToken());
			stores[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		festival[0] = Integer.parseInt(st.nextToken());
		festival[1] = Integer.parseInt(st.nextToken());
	}
}