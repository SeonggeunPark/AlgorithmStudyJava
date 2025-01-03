import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int size, front, back;
	static int[] q;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		q = new int[100000];
		size = 0;
		front = 0;
		back = 0;
		
		// 작업 시작
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push": {
				push(Integer.parseInt(st.nextToken()));
				break;
			}
			case "pop": {
				pop();
				break;
			}
			case "size": {
				System.out.println(size);
				break;
			}
			case "empty": {
				if (size>0) System.out.println(0);
				else System.out.println(1);
				break;
			}
			case "front": {
				if (size > 0) System.out.println(q[front]);
				else System.out.println(-1);
				break;
			}
			case "back": {
				if (size > 0) System.out.println(q[back-1]);
				else System.out.println(-1);
				break;
			}
			default:
				break;
			}
		}
		
	}
	static void pop() {
		if (size > 0) {
			System.out.println(q[front]);
			q[front++] = 0;
			size -= 1;
		} else {
			System.out.println(-1);
		}
	}
	static void push(int i) {
		q[back++] = i;
		size += 1;
	}
}
