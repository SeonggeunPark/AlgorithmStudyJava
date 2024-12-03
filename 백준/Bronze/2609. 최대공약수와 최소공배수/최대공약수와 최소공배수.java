import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// 최대공약수
		for (int i=Math.min(a, b); i>=1; i--) {
			if (a%i==0 && b%i==0) {
				sb.append(i).append('\n');
				break;
			}
		}
		// 최소공배수
		for (int i=Math.max(a, b); i<=a*b; i++) {
			if (i%a==0 && i%b==0) {
				sb.append(i);
				break;
			}
		}
		
		System.out.println(sb);
	}
}
