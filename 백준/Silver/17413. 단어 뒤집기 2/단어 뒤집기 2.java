import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();

		char[] arr = br.readLine().toCharArray();
		for (char c : arr) {
			if (!queue.isEmpty() || c == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				if (c == '>') {
					queue.add(c);
					while (!queue.isEmpty()) {
						sb.append(queue.poll());
					}
					continue;
				}
				queue.add(c);
				continue;
			}
			
			if (c == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(c);
				continue;
			}
			
			while (!queue.isEmpty()) {
				sb.append(queue.poll());
			}
			stack.push(c);
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}
}
