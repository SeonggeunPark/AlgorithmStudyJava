import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		
		int T = Integer.parseInt(br.readLine()); // 케이스 수 입력
		// 테스트케이스 순회
		for (int t=1; t<=T; t++) {
			// 연산의 수
			int n = Integer.parseInt(br.readLine());
			
			// 초기화
			tm.clear();
			
			// 연산 입력
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String com = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if (com.equals("I")) {
					tm.put(num, tm.getOrDefault(num, 0)+1); // 해당 값에 대해 개수 +1 증가
				} else {
					if (tm.isEmpty()) continue;
					// 최소값 제거
					if (num == -1) {
						if (tm.get(tm.firstKey()) <= 1) {
							tm.remove(tm.firstKey());
						} else {
							tm.put(tm.firstKey(), tm.get(tm.firstKey())-1);
						}
					}
					// 최대값 제거
					else {
						if (tm.get(tm.lastKey()) <= 1) {
							tm.remove(tm.lastKey());
						} else {
							tm.put(tm.lastKey(), tm.get(tm.lastKey())-1);
						}
					}
				}
				
			}
			if (tm.isEmpty()) System.out.println("EMPTY");
			else {
				System.out.print(tm.lastKey()+" ");
				System.out.println(tm.firstKey());
			}
		}
	}
}
