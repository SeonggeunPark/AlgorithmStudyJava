import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int ans, idx;
	static char[] input;

	public static void main(String[] args) throws IOException {
		init();

		Stack<Character> st = new Stack<>();
		ans = solve();

		if (ans == -1 || idx != input.length) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}
	}

    static int solve() {
        int sum = 0;

        while (idx < input.length) {
            char c = input[idx++];

            if (c == '(') {
                int inner = solve();
                if (inner == -1 || idx >= input.length || input[idx] != ')') return -1;
                idx++; // 닫는 괄호 소비
                sum += inner == 0 ? 2 : 2 * inner;
            } else if (c == '[') {
                int inner = solve();
                if (inner == -1 || idx >= input.length || input[idx] != ']') return -1;
                idx++; // 닫는 괄호 소비
                sum += inner == 0 ? 3 : 3 * inner;
            } else if (c == ')' || c == ']') {
                // 상위에서 닫는 괄호 확인하도록 돌려줌
                idx--; // 다시 닫는 괄호를 상위에서 보게 하기 위해 되돌림
                return sum;
            } else {
                return -1; // 잘못된 문자
            }
        }

        return sum;
    }

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		input = br.readLine().toCharArray();
		ans = 0;
		idx = 0;
	}
}
