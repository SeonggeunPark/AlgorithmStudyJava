import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		// 알파벳들 등장 여부 저장할 배열
		// a(97)가 0번 인덱스에 위치하도록
		int[] alphabets = new int[26];	
		
		Arrays.fill(alphabets, -1);	// 모두 -1로 초기화
		
		for (int i=0; i<str.length(); i++) {
			int idx = str.charAt(i)-97;
			
			if (alphabets[idx] == -1) alphabets[idx] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : alphabets) {
			sb.append(i).append(' ');
		}
		System.out.println(sb);
	}
}
