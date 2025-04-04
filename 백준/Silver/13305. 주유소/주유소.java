import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] cities = new int[N];
		int[] dist = new int[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int min = Integer.parseInt(st.nextToken());
		int sum = 0;
		cities[0] = min;
		for (int i=1; i<N; i++) {
			sum += min * dist[i-1];
			cities[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, cities[i]);
		}
		
		System.out.println(sum);
	}
}
