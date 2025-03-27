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

		HashMap<String, Integer> map = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		int maxCnt = 0;
		String ans = null;
				
		for (int i = 0; i < n; i++) {
			String title = br.readLine();
			map.put(title, map.getOrDefault(title, 0)+1);
			
			if (map.get(title) > maxCnt) {
				ans = title;
				maxCnt = map.get(title);
			} else if (map.get(title) == maxCnt) {
				if (ans.compareTo(title) > 0) {
					ans = title;
				}
			}
		}

		System.out.println(ans);
	}
}
