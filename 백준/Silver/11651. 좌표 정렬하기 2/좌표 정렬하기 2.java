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
	public static class Coord implements Comparable<Coord>{
		int x, y;
		public Coord() {
			// TODO Auto-generated constructor stub
		}
		public Coord(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Coord o) {
			if (this.y == o.y) {
				return this.x-o.x;
			}
			return this.y-o.y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Coord> pq = new PriorityQueue<>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Coord coord = pq.poll();
			sb.append(coord.x).append(' ').append(coord.y).append('\n');
		}
		
		System.out.println(sb);
	}

}
