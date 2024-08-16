import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 괄호 안 문자는 Queue에 담고, 일반 문자는 Stack에 담아
 * 특정 조건에 다다르면 StringBuilder에 담도록 설계하였음.
 * 
 * 큐와 스택은 배열 작업에 비해 속도가 느리기 때문에,
 * 해당 기능을 사용하는 대신 받은 배열에서 직접 처리하는 것이 더 효율적임.
 * 추후 배열로 해결할 수 있는 문제는 배열로 최대한 해결하는 것을 지향할 것
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 일반 문자, 숫자를 담아 처리할 Stack
		Stack<Character> stack = new Stack<>();
		// <> 안 문자를 담아 처리할 Queue
		Queue<Character> queue = new LinkedList<>();

		// 입력받은 문자를 배열에 담아 작업
		char[] arr = br.readLine().toCharArray();
		for (char c : arr) {
			// 1. 문자가 '<'이거나 큐에 문자가 들어있을 때
			// => (1)stack에 들어있던 문자를 출력해 문자 뒤집어 출력
			// => (2)입력된 문자가 '>'이면 큐에 담은 후 문자 그대로 출력
			// => (3)그 외의 경우 큐에 담음
			if (!queue.isEmpty() || c == '<') {
				// (1)
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				// (2)
				if (c == '>') {
					queue.add(c);
					while (!queue.isEmpty()) {
						sb.append(queue.poll());
					}
					continue;
				}
				// (3)
				queue.add(c);
				continue;
			}
			// 2. 문자가 공백일 경우 =>
			// 앞에서 큐에 대한 작업 모두 처리했으므로,
			// 하나의 단어가 끝나는 것이므로 stack에 담긴 문자열 뒤집어 출력
			// 이후 공백 출력
			if (c == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(c);
				continue;
			}
			// 3. 나머지 경우 => 일반 문자 or 숫자
			// => (1) 큐에 들어있던 문자열 그대로 출력
			// => (2) 스택에 문자 담음
			// (1)
			while (!queue.isEmpty()) {
				sb.append(queue.poll());
			}
			// (2)
			stack.push(c);
		}
		// 반복 종료 시 stack에 문자열 남아있을 수 있으므로 뒤집어 출력 처리
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}
}
