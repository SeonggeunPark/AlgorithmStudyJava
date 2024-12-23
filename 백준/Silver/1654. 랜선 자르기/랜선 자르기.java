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

/*
 * 이분 탐색 ㅠㅠ
 */
public class Main {
	static int N, K;
	static long max, ans;
	static long[] cables;

	public static void main(String[] args) throws IOException {
		
		init();
		
		binarySearch(1, max);
		
		System.out.println(ans);
	}
	
	// 이진 탐색하여 최종 값 산출
	private static void binarySearch(long start, long end) {
		// start 보다 end가 작아지면 더이상 탐색 불가하므로 종료
		if (start > end) {
			return;
		}
		
		long mid = (start+end)/2;	// 중간값 계산
		
		// 랜선 N개를 만들 수 있는지 확인
		// (1) 만들 수 있으면 더 큰 길이로도 만들 수 있는지 확인
		if (check(mid)) {
			ans = Math.max(ans, mid);
			binarySearch(mid+1, end);
		// (2) 못 만들면 더 작은 길이를 찾음
		} else {
			binarySearch(start, mid-1);
		}
	}

	// cutLen 길이로 랜선을 N개 이상 만들 수 있는지 확인
	private static boolean check(long cutLen) {
		long count = 0; // 가능한 랜선 총 개수를 저장
		
		for (long cable : cables) {
			count += cable/cutLen;	// 해당 케이블을 cutLen만큼 잘랐을 때 만들 수 있는 총 개수
		}
		
		// N개 이상 만들 수 있으면 true를 반환
		return count >= N;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());	// 기존 랜선 개수
		N = Integer.parseInt(st.nextToken());	// 잘라 만들어낼 랜선 개수
		max = 0;	// 기존 랜선 길이 최대값 저장
		ans = 0; 	// N개로 만들 수 있는 최대 랜선 길이
		
		cables = new long[K];
		for (int i=0; i<K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
			if (max < cables[i]) {
				max = cables[i];
			}
		}
	}
}
