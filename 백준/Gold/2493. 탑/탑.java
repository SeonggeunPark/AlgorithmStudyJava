import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());
	        int[] towers = new int[n];
	        int[] answer = new int[n];
	        StringTokenizer s = new StringTokenizer(br.readLine());
	        for (int i=0; i<n; i++) {
	            towers[i] = Integer.parseInt(s.nextToken());
	        }

	        // 인덱스 기록 스택
	        Stack<Integer> st = new Stack<>();
	        for (int i=0; i<n; i++) {
	            // 스택과 비교
	            // 높이가 같거나 높으면 기록 후 push
	            // 낮으면 pop (같거나 높은거 나올때까지)
	            while (!st.isEmpty() && towers[st.peek()]<towers[i]) {
	                st.pop();
	            }

	            if (st.isEmpty()) {
	                answer[i] = 0;
	            } else {
	                answer[i] = st.peek()+1;
	            }
	            st.push(i);
	        }
	        StringBuilder sb = new StringBuilder();
	        for (int i=0; i<n; i++) {
	            sb.append(answer[i]).append(' ');
	        }
	        System.out.println(sb.toString());
	}
}