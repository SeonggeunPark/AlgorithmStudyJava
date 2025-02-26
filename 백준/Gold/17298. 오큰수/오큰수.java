import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       int n = Integer.parseInt(br.readLine());
	        int[] arr = new int[n];
	        int[] result = new int[n];
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        for (int i = 0; i < n; i++) {
	        	arr[i] = Integer.parseInt(st.nextToken());
	        }

	        Stack<Integer> stack = new Stack<>();
	        
	        for (int i=0; i<n; i++) {
	        	while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
	        		result[stack.pop()] = arr[i];
	        	}
	        	stack.push(i);
	        }
	        
	        // 아직 스택에 남아있는 건 모두 -1
	        while(!stack.isEmpty()) {
	        	result[stack.pop()] = -1;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for (int num : result) {
	        	sb.append(num).append(' ');
	        }
	        
	        System.out.println(sb);
	}
}
