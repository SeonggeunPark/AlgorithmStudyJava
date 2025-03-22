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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		// 참가번호 입력
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		
		// 소속이 달라질 때까지
		// 소속 구하기 (2의 n-1제곱보다는 크고, 2의 n제곱보다는 작거나 같을 때, n 값을 구하기) 
		int kim_bitCnt = countDigit(kim);
		int lim_bitCnt = countDigit(lim);
		
		while (kim_bitCnt == lim_bitCnt) {
			kim -= Math.pow(2, lim_bitCnt-1);
			lim -= Math.pow(2, lim_bitCnt-1);
			
			kim_bitCnt = countDigit(kim);
			lim_bitCnt = countDigit(lim);
		}
		
		System.out.println(Math.max(kim_bitCnt, lim_bitCnt));
		
	}

	private static int countDigit(int num) {
		for (int i=0; i<=17; i++) {
			if (num <= Math.pow(2, i)) {
				return i;
			}
		}
		return -1;
	}
}
