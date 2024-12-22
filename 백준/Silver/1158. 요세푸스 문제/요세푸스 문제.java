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
		int pointer = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		while (size<N) {
			pointer = (pointer + K - 1) % list.size();
			ans[size++] = list.remove(pointer);
		}
	}
}
