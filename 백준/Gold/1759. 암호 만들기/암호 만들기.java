import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] letters;
	static char[] pick;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		letters = new char[C];
		pick = new char[L];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<C; i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(letters);
		
		combination(0, 0);
	}
	private static void combination(int lidx, int pidx) {
		if (pidx >= L) {
			if(!check()) {
				return;
			}
			for (char c: pick) {
				sb.append(c);
			}
			System.out.println(sb);
			sb.setLength(0);
			return;
		}
		
		if (lidx >= C) {
			return;
		}
		
		// 뽑는다
		pick[pidx] = letters[lidx];
		combination(lidx+1, pidx+1);
		// 안뽑는다
		combination(lidx+1, pidx);
	}
	private static boolean check() {
		int consonant = 0; // 자음
		int vowel = 0; // 모음
		for (char c : pick) {
			if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
				vowel += 1;
			} else {
				consonant += 1;
			}
			if (vowel>=1 && consonant >= 2) {
				return true;
			}
		}
		return false;
	}
}
