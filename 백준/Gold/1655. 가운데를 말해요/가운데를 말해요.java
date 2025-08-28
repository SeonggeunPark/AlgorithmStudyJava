import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  숫자가 주어질 때마다 삽입정렬.
 *  삽입 위치 찾는건 이분탐색으로.
 *  중간값은 짝수->len/2-1 홀수->len/2 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static int N;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		init();
		
		for (int i=0; i<N; i++) {
			int newNum = Integer.parseInt(br.readLine());
			int targetIdx = binarySearch(0, list.size()-1, newNum);
			
			list.add(targetIdx, newNum);
			
			int midIdx = list.size()/2;
			if (list.size()%2 == 0) midIdx -= 1;
			
			sb.append(list.get(midIdx)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int binarySearch(int s, int e, int target) {
		int mid = (s+e)/2;
		if (s > e) {
			return s;
		}
		
		int midNum = list.get(mid);
		if (midNum == target) {
			return mid;
		} else if(midNum < target) {
			return binarySearch(mid+1, e, target);
		} else {
			return binarySearch(s, mid-1, target);
		}
	}

	private static void init() throws IOException {
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
	}
}
