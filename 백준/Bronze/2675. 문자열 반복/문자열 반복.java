import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String S = st.nextToken();

			for (int i = 0; i < S.length(); i++) {
				if (S.charAt(i) == '\\') {
					for (int j = 0; j < n; j++) {
						sb.append('\\');
					}
				} else {
					for (int j = 0; j < n; j++) {
						sb.append(S.charAt(i));
					}
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}
