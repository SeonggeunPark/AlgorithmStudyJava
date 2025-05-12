import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();

		int widx = 0;
		int cnt = 0;

		while (widx <= word.length - p.length) {
			boolean match = true;

			for (int i = 0; i < p.length; i++) {
				if (word[widx + i] != p[i]) {
					match = false;
					break;
				}
			}

			if (match) {
				cnt++;
				widx += p.length; // 겹치지 않도록 이동
			} else {
				widx++;
			}
		}

		System.out.println(cnt);
	}
}
