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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// A:0 부터 시작, a:32부터 시작, 맨앞글자별로 구분하여 인덱스값 저장
		ArrayList<Integer>[] dict = new ArrayList[57];
		for (int i=0; i<57; i++) {
			dict[i] = new ArrayList<>();
		}
		
		// 단어 입력
		String[] words = new String[N];
		for (int i=0; i<N; i++) {
			words[i] = br.readLine();
			dict[words[i].charAt(0)-65].add(i);
		}
		
		// 포켓몬 찾기
		out: for  (int i=0; i<M; i++) {
			String input = br.readLine();
			// 알파벳이면
			if(input.charAt(0)-65>=0) {
				for (int idx : dict[input.charAt(0)-65]) {
					if (words[idx].equals(input)) {
						System.out.println(idx+1);
						continue out;
					}
				}
			}
			// 숫자면
			else {
				System.out.println(words[Integer.parseInt(input)-1]);
			}
		}
	}
}
