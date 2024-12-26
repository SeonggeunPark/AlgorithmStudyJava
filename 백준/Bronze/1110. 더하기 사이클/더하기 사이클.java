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
 */
public class Main {
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 구현
		int ans = simulation(N);
		
		// 출력
		System.out.println(ans);
	}

	private static int simulation(int n) {
		int cnt = 1;
		int curr = n;
		
		// 반복문
		do {
			// 1. 각 자리수 더하기
			int nextNum = addDigit(curr < 10 ? curr*10 : curr);
			// 2. 처음 수와 새로운 수 각각 맨 오른쪽 수 이어붙이기
			int newNum = link(curr%10, nextNum%10);
			// 3. 원래 수와 일치하는지 확인
			// 3-1. 일치하면 사이클 수 반환
			if (newNum == n) return cnt;
			// 3-2. 일치하지 않으면 사이클 수 1 증가시킨 후 반복
			cnt += 1;
			curr = newNum;
			
		} while(curr != n);
		
		return cnt;
		
		
	}

	private static int link(int i, int j) {
		return i*10+j;
	}

	private static int addDigit(int curr) {
		return curr/10+curr%10;
	}
}
