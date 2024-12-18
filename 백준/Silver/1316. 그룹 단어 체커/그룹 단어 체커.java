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
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		// 배열 입력
		for (int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		
		int cnt = 0;
		// 단어별 처리
		for (String word : words) {
			if (check(word))
				cnt+=1;
		}
		
		System.out.println(cnt);
	}
	private static boolean check(String word) {
		// 아스키코드 활용 알파벳 별 방문배열 선언(a : 97 -> 0)
		boolean[] visited = new boolean[26];
		
		visited[word.charAt(0)-97] = true;	// 첫 문자 방문체크
		
		// 2번째 문자부터 확인
		for (int i=1; i<word.length(); i++) {
			// 방문체크배열 인덱스값으로 수치 보정
			int n = word.charAt(i)-97;
			
			// 아직 나오지 않은 문자이면 방문체크 후 패스
			if (!visited[n]) {
				visited[n] = true;
				continue;
			}
			
			// 이미 나온 문자면 이전 문자가 같은 문자인지 확인
			if (n == word.charAt(i-1)-97) 
				continue;
			// 이전 문자와 다른 문자이면 false 반환
			return false;
		}
		// 문제 없이 확인이 끝나면 true 반환
		return true;
	}
}
