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
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int a, A, b, B;
	static int[] ans;
	public static void main(String[] args) throws IOException {	
		init();
		
		int C = A * B;
		int c = a*B + b*A;
		
		int gcd = getGCD(c, C);
		sb.append(c/gcd).append(' ').append(C/gcd);
		System.out.println(sb);
	}
	
	private static int getGCD(int a, int b) {
		int tmp;
		while(b>0) {
			tmp = b;
			b = a%b;
			a = tmp;
		}
		
		return a;
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}
}
