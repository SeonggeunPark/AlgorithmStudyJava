import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		out: while (true) {
			s.clear();
			char[] arr = br.readLine().toCharArray();
//			sb.append(Arrays.toString(arr)).append('\n');
			// 마지막줄인지 검사
			if (arr.length==1 && arr[0]=='.') {
				break;
			}
			
			for (char c : arr) {
				if(c=='(' || c=='[')
					s.push(c);
				if(c==')') {
					if(s.size()>0 && s.peek() == '(') {
						s.pop();
					} else {
						sb.append("no").append('\n');
						continue out;
					}
				}
					
				if (c==']') {
					if(s.size()>0 && s.peek() == '[') {
						s.pop();
					} else {
						sb.append("no").append('\n');
						continue out;
					}
				}
			}
			if(s.isEmpty()) {
				sb.append("yes").append('\n');
			} else {
				sb.append("no").append('\n');
			}
		}
		
		System.out.println(sb);
		
	}
}
