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
	static int N, K, size;
	static boolean[] survived;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력값 입력
		N = Integer.parseInt(st.nextToken()); // 사람 수
		K = Integer.parseInt(st.nextToken()); // 제거 규칙

		survived = new boolean[N + 1]; // 생존 여부를 기록
		Arrays.fill(survived, true);  // 시작은 모두 생존으로 처리
		
		ans = new int[N]; // 제거된 사람 기록
		size = 0; // ans배열의 크기 기록

		eliminate();

		print();
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		for (int i = 0; i < N; i++) {
			if (i < N - 1)
				sb.append(ans[i]).append(',').append(' ');
			else
				sb.append(ans[i]).append('>');
		}

		System.out.println(sb);
	}

	private static void eliminate() {
		// 첫번째 제거 대상 제거 후 반복작업 수행
		int pointer = K;
		survived[K] = false;
		ans[size++] = K;

		// 모두 제거될 때까지 작업 반복
		while (size < N) {
			int cnt = K;	// 포인터 이동횟수 카운터
			
			while (cnt > 0) {
				pointer += 1;	
				if (pointer>N) pointer %= N;	// 모듈러 연산
				if (survived[pointer]) cnt -= 1;	// 포인터가 생존했을 경우에만 카운트 줄임
			}
			
			survived[pointer] = false;
			ans[size++] = pointer;
		}
		
		
	}

}
