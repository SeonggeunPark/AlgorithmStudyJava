import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] charArr = br.readLine().toCharArray();
		int cnt = 0;
		for (int i = 0; i < charArr.length; i++) {
			char c = charArr[i];
			// 배열 마지막이면 1글자 센 후 break;
			if (i == charArr.length - 1) {
				cnt++;
				break;
			}

			if (c == 'c') {
				if (charArr[i + 1] == '=' || charArr[i + 1] == '-') {
					cnt++;
					i += 1;
				} else {
					cnt++;
				}
			} else if (c == 'd') {
				if (charArr[i + 1] == 'z') {
					if (i+2 < charArr.length && charArr[i + 2] == '=') {
						cnt++;
						i += 2;
					} else {
						cnt += 2;
						i += 1;
					}
				} else if (charArr[i + 1] == '-') {
					cnt++;
					i += 1;
				} else {
					cnt++;
				}
			} else if (c == 'l') {
				if (charArr[i + 1] == 'j') {
					cnt++;
					i += 1;
				} else {
					cnt++;
				}
			} else if (c == 'n') {
				if (charArr[i + 1] == 'j') {
					cnt++;
					i += 1;
				} else {
					cnt++;
				}
			} else if (c == 's' || c == 'z') {
				if (charArr[i + 1] == '=') {
					cnt++;
					i += 1;
				} else {
					cnt++;
				}
			} else {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
