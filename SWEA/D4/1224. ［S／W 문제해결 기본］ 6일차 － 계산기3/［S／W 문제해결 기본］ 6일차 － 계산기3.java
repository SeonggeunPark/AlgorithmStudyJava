import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			char[] arr = new char[n];
			String str = br.readLine();

			// 입력받은 식을 문자 배열에 1개씩 분리 저장
			for (int i = 0; i < n; i++) {
				arr[i] = str.charAt(i);
			}

			System.out.printf("#%d %d \n", t, evalPostfix(infixToPostfix(arr)));
		}

	}

	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('(', 0);
		map.put('*', 2);
		map.put('+', 1);
	}

	static String infixToPostfix(char[] arr) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (Character c : arr) {

			if ('0' <= c && c <= '9') {
				sb.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					sb.append(popItem);
					popItem = stack.pop();
				}
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					sb.append(popItem);
				}
				stack.push(c);
			}

		}

		while (!stack.isEmpty()) {
			char popItem = stack.pop();
			sb.append(popItem);
		}

		return sb.toString();
	}

	static int evalPostfix(String str) {
		Stack<Integer> stack = new Stack<>();
		int num1;
		int num2;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if ('0' <= c && c <= '9') {
				stack.push(Character.getNumericValue(c));
			} else if (c == '+') {
				num1 = stack.pop();
				num2 = stack.pop();

				stack.push(num1 + num2);
			} else {
				num1 = stack.pop();
				num2 = stack.pop();

				stack.push(num1 * num2);
			}
		}

		return stack.pop();
	}

}
