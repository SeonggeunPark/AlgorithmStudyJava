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
	static int[] opCnts;
	static int[] nums;
	static int max, min, N;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		nums = new int[N];
		opCnts = new int[4];
		
		// 수열 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			opCnts[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(1, nums[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	private static void DFS(int nIdx, int res) {
		// 맨 끝 수까지 도달하면 종료
		if (nIdx >= N) {
			max = Math.max(res, max);
			min = Math.min(min, res);
			return;
		}
		
		// 연산자 선택
		for (int i=0; i<4; i++) {
			if (opCnts[i] > 0) {
				opCnts[i] -= 1;
				DFS(nIdx+1, cal(res, i, nums[nIdx]));
				opCnts[i] += 1;
			}
		}		
	}
	private static int cal(int a, int op, int b) {
		if (op == 0) return a+b;
		else if (op == 1) return a-b;
		else if (op==2) return a*b;
		else return a/b;
	}
}
