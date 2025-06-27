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
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M, min, digit;
	static int[] brokens, normals;
	static boolean[] isBroken;

	public static void main(String[] args) throws IOException {
		init();

		min = Math.abs(N - 100);
		// 1. 모든 버튼이 고장나면 + - 버튼으로 이동 후 종료
		if (M >= 10) {
			System.out.println(min);
			return;
		}

		// 숫자패드로 가능한 최적값 찾기
		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			boolean isPossible = true;

			for (int j = 0; j < str.length(); j++) {
				if (isBroken[str.charAt(j) - '0']) {
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				int pressCount = str.length() + Math.abs(i - N); // 숫자 길이 + +/- 조정
				min = Math.min(min, pressCount);
			}
		}

		System.out.println(min);
	}

	static void init() throws IOException {

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		digit = String.valueOf(N).length();

		normals = new int[10 - M];
		isBroken = new boolean[10];
		// 고장난 숫자패드 입력 받은 후 boolean 배열에 저장
		if (M > 0) {
			brokens = new int[M];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int n = Integer.parseInt(st.nextToken());
				isBroken[n] = true;
			}
		}
		// 고장난패드, 정상 패드 배열에 각각 배정
		int bIdx = 0;
		int nIdx = 0;
		for (int i = 0; i <= 9; i++) {
			if (isBroken[i]) {
				brokens[bIdx++] = i;
			} else {
				normals[nIdx++] = i;
			}
		}
	}
}
