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
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0)
				if (!pq.isEmpty())
					sb.append(pq.poll()).append('\n');
				else
					sb.append('0').append('\n');
			else
				pq.offer(input);
		}

		System.out.println(sb);

	}
}
