import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 연산자를 담을 스택
		Stack<Character> st = new Stack<>();

		// 괄호 처리를 위한 임시 스택
		StringBuilder ans = new StringBuilder();

		char[] inputs = br.readLine().toCharArray();
		for (char c : inputs) {
			// 연산자일 때
			// 후순위 연산자면 여는괄호 나올때까지 모두 pop
			if (c == '+' || c == '-') {
				while (!st.isEmpty() && st.peek() != '(') {
					ans.append(st.pop());
				}
				st.push(c);
			}
			// 우선순위 연산자도 동일 우선순위일 경우 모두 pop
			else if (c == '*' || c == '/') {
				while (!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')) {
					ans.append(st.pop());
				}
				st.push(c);
			} else if (c == '(') {
				st.push(c);
			}
			// 닫는 괄호일 때
			else if (c == ')') {
				// 여는 괄호가 나올 때까지 pop
				while (st.peek() != '(') {
					ans.append(st.pop());
				}
				// 여는 괄호 제거
				st.pop();
			}
			// 피연산자일 땐 바로 ans 저장
			else {
				ans.append(c);
			}
		}
		// 남은것 비우기
		while (!st.isEmpty()) {
			ans.append(st.pop());
		}

		System.out.println(ans);

	}
}