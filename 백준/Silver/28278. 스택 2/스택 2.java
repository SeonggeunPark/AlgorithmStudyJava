import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			if (com==1) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			} else if (com==2) {
				System.out.println(stack.isEmpty() ? -1 : stack.pop());
			} else if (com==3) {
				System.out.println(stack.size());
			} else if (com==4) {
				System.out.println(stack.isEmpty() ? 1 : 0);
			} else {
				System.out.println(stack.isEmpty() ? -1 : stack.peek());
			}
		}
	}
}