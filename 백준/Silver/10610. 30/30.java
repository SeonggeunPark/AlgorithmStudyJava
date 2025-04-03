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
		char[] nums = br.readLine().toCharArray();
		int[] ans = new int[nums.length];
		
		int sum = 0;
		int idx = 0;
		for (char c : nums) {
			int num = c-'0';
			sum += num;
			ans[idx++] = num;
		}
		if (sum%3 != 0) {
			System.out.println(-1);
			return;
		}
		
		Arrays.sort(ans);
		if (ans[0] != 0) {
			System.out.println(-1);
			return;
		}
		for (int i=ans.length-1; i>=0 ; i--) {
			System.out.print(ans[i]);
		}
	}
}
