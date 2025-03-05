import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int cnt = 0;

		for (int i = 0; i < input.length; i++) {
			char c = input[i];
			if (c == '(') {
				if (input[i + 1] != ')') {
					stack.push(c);
					cnt += 1;
				} else {
					cnt += stack.size();
					i += 1;
				}
			} else {
				stack.pop();
			}
		}

		System.out.println(cnt);
	}
}
