import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 단어 앞글자를 이옹해 알파벳 별로 저장
		ArrayList<String>[] dictionary = new ArrayList[26];
		for (int i=0; i<26; i++) {
			dictionary[i] = new ArrayList<>();
		}	// 각 인덱스에 리스트 초기화
		
		// 단어 입력받아 알파벳별 분류 저장
		for (int i=0; i<N; i++) {
			String word = br.readLine();
			dictionary[word.charAt(0)-'a'].add(word);
		}
		
		int count = 0;
		// 탐색
		for (int i=0; i<M; i++) {
			String targetWord = br.readLine();
			// 주어진 단어 앞글자를 통해 필요한 요소만 탐색
			for (String word : dictionary[targetWord.charAt(0)-'a']) {
				if (word.equals(targetWord)) {
					count += 1;
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}